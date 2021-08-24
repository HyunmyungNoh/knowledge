package com.solugate.knowledge.domain.origin;

import com.solugate.knowledge.KnowledgeApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = KnowledgeApplication.class)
@RunWith(SpringRunner.class)
public class OriginDatasetRepositoryTest {

    @Autowired
    private OriginDatasetRepository originDatasetRepository;

    @Autowired
    private OriginFileRepository originFileRepository;

    // Insert
    @Test
    public void 데이터셋_저장() {
        String odName = "방송0002";
        String odDir = "D:/Download";
        String categoryCd = "10";
        Timestamp createDate = new Timestamp(System.currentTimeMillis());

        //given
        OriginDataset originDataset = OriginDataset.builder()
                .odName(odName)
                .odDir(odDir)
                .categoryCd(categoryCd)
                .createDate(createDate)
                .build();

        //when
        Long testId = originDatasetRepository.save(originDataset).getId();

        //then
        assertTrue(testId > 0);
    }

    // Read
    @Test
    public void 데이터셋_가져오기() {
        //given

        //when
        List<OriginDataset> datasetList = originDatasetRepository.findAll();

        //then
        if (datasetList.size() > 0) {
            for (OriginDataset o : datasetList) {
                System.out.println(o.getOdName());
            }
        } else {
            System.out.println("데이터셋이 없습니다.");
        }
    }

    // Delete
    @Test
    public void 데이터셋_삭제() {
        //given
        Optional<OriginDataset> d = originDatasetRepository.findById(2L);

        //when
        d.ifPresent(selectedSet -> {
            System.out.println("데이터셋 이름 : " + selectedSet.getOdName());
            originDatasetRepository.delete(selectedSet);
        });

        //then
    }



    @Test
    public void 데이터파일_저장() {
        String ofDir = "D:/Download/방송0002";
        String ofWavNm = "korspeech00001";
        Timestamp createDate = new Timestamp(System.currentTimeMillis());

        //given
        OriginFile originFile = OriginFile.builder()
                .ofDir(ofDir)
                .ofWavNm(ofWavNm)
                .createDate(createDate)
                .odId(1L)
                .build();

        //when
        Long testId = originFileRepository.save(originFile).getId();

        //then
        assertTrue(testId > 0);
    }

}
