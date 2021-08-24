package com.solugate.knowledge.domain;

import com.solugate.knowledge.controller.dto.FileSaveDto;
import com.solugate.knowledge.controller.dto.FolderSaveDto;
import com.solugate.knowledge.domain.origin.OriginDataset;
import com.solugate.knowledge.domain.origin.OriginDatasetRepository;
import com.solugate.knowledge.domain.origin.OriginFile;
import com.solugate.knowledge.domain.origin.OriginFileRepository;
import com.solugate.knowledge.domain.revision.RevDataset;
import com.solugate.knowledge.domain.revision.RevDatasetRepository;
import com.solugate.knowledge.domain.revision.RevFile;
import com.solugate.knowledge.domain.revision.RevFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FileService {
    private final OriginDatasetRepository originDatasetRepository;
    private final OriginFileRepository originFileRepository;
    private final RevDatasetRepository revDatasetRepository;
    private final RevFileRepository revFileRepository;


    @Transactional
    public void saveData(FolderSaveDto folderDto) {

        long id = 0;
        int flag = 0;
//        Timestamp date;
        /* id 유무로 신규 저장, 수정본 저장 구분*/
        OriginDataset odSet = null;
        RevDataset revSet = null;
        // id가 없다면 원본(신규) 저장 --> 서비스가 아니라 컨트롤러로 뺄 듯
        if (folderDto.getId() == null) {
            flag = 1;
            odSet = folderDto.toEntity();
            id = originDatasetRepository.save(odSet).getId();

        // id가 있다면 수정본 저장(수정 대상의 원본 폴더가 들어온다는 전제 하에)
        } else if (folderDto.getId() > 0) {
            revSet = RevDataset.builder()
                    .categoryCd(folderDto.getCategoryCd())
                    .rdDir(folderDto.getOdDir())
                    .rdName(folderDto.getOdName())
                    .createDate(new Timestamp(System.currentTimeMillis()))
                    .odId(folderDto.getId())
                    .build();

            id = revDatasetRepository.save(revSet).getId();
        }

        List<FileSaveDto> ofDtos = folderDto.getFileSaveDtos();
        this.saveToFileDto(ofDtos, id, flag);
    }

    // 데이터 파일 저장
    private void saveToFileDto(List<FileSaveDto> ofDtos, Long odId, int flag) {
//        ofDtos.stream().map(odId::odId);
//        ArrayList fileList = new ArrayList();
        if (flag > 0) {
            List<OriginFile> fileList = new ArrayList<OriginFile>();
            for (FileSaveDto dto : ofDtos) {
                OriginFile orgfile = dto.toOrigEntity();
                orgfile.updateOdId(odId);
                fileList.add(orgfile);
            }
            originFileRepository.saveAll(fileList);
        } else if (flag == 0) {
            List<RevFile> fileList = new ArrayList<RevFile>();
            for (FileSaveDto dto : ofDtos) {
                RevFile revfile = dto.toRevEntity();
                revfile.updateRdId(odId);
                fileList.add(revfile);
            }
            revFileRepository.saveAll(fileList);
        }
    }

    @Transactional
    public void findBy(String categoryCd) {
         List<OriginDataset> originDatasets = originDatasetRepository.findAllByCategoryCd(categoryCd);
         for (OriginDataset o : originDatasets) {
             System.out.println("카테고리 : " + o.getCategoryCd() + " / 데이터셋 이름 : " + o.getOdName());
         }
    }
}
