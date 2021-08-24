package com.solugate.knowledge.domain;

import com.solugate.knowledge.KnowledgeApplication;
import com.solugate.knowledge.controller.dto.FileSaveDto;
import com.solugate.knowledge.controller.dto.FolderSaveDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = KnowledgeApplication.class)
@RunWith(SpringRunner.class)
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    /**********저장 */

    @Test
    public void 원본폴더_저장() {
        // given

        // value들
        String odName = "취미0001";
        String odDir = "D:/hobby";
        String categoryCd = "12";
        Timestamp createDate = new Timestamp(System.currentTimeMillis());

        String ofDir = odDir + "/" + odName;
        String ofWavNm = "영화보기.wav";
        long ofWavSize = 10;
        String ofTxtNm = "영화보기.txt";
        long ofTxtSize = 20;
        String ofMetaNm = "영화보기.json";

        FileSaveDto ofdto = FileSaveDto.builder()
                .ofDir(ofDir)
                .ofWavNm(ofWavNm)
                .ofWavSize(ofWavSize)
                .ofTxtNm(ofTxtNm)
                .ofTxtSize(ofTxtSize)
                .ofMetaNm(ofMetaNm)
                .createDate(createDate)
                .build();

        FileSaveDto ofdto2 = FileSaveDto.builder()
                .ofDir(ofDir + '1')
                .ofWavNm(ofWavNm)
                .ofWavSize(ofWavSize)
                .ofTxtNm(ofTxtNm)
                .ofTxtSize(ofTxtSize)
                .ofMetaNm(ofMetaNm)
                .createDate(createDate)
                .build();

        List<FileSaveDto> ofdtos = new ArrayList<>(Arrays.asList(ofdto, ofdto2));

        FolderSaveDto odDto = FolderSaveDto.builder()
                .odName(odName)
                .odDir(odDir)
                .categoryCd(categoryCd)
                .createDate(createDate)
                .fileSaveDtos(ofdtos)
                .build();

        // when
        fileService.saveData(odDto);

        // then
        System.out.println("종료되었습니다.");
    }


    @Test
    public void 수정본폴더_저장() {
        long odId = 1;
        String odName = "취미0001_수정";
        String odDir = "D:/수정/hobby";
        String categoryCd = "12";
        Timestamp createDate = new Timestamp(System.currentTimeMillis());

        String ofDir = odDir + "/" + odName;
        String ofWavNm = "영화보기_수정.wav";
        long ofWavSize = 20;
        String ofTxtNm = "영화보기_수정.txt";
        long ofTxtSize = 30;
        String ofMetaNm = "영화보기_수정.json";

        FileSaveDto ofdto = FileSaveDto.builder()
                .ofDir(ofDir)
                .ofWavNm(ofWavNm)
                .ofWavSize(ofWavSize)
                .ofTxtNm(ofTxtNm)
                .ofTxtSize(ofTxtSize)
                .ofMetaNm(ofMetaNm)
                .createDate(createDate)
                .build();

        FileSaveDto ofdto2 = FileSaveDto.builder()
                .ofDir(ofDir + '1')
                .ofWavNm(ofWavNm)
                .ofWavSize(ofWavSize)
                .ofTxtNm(ofTxtNm)
                .ofTxtSize(ofTxtSize)
                .ofMetaNm(ofMetaNm)
                .createDate(createDate)
                .build();

        List<FileSaveDto> ofdtos = new ArrayList<>(Arrays.asList(ofdto, ofdto2));

        FolderSaveDto odDto = FolderSaveDto.builder()
                .id(odId)
                .odName(odName)
                .odDir(odDir)
                .categoryCd(categoryCd)
                .createDate(createDate)
                .fileSaveDtos(ofdtos)
                .build();

        // when
        fileService.saveData(odDto);

        // then
        System.out.println("종료되었습니다.");
    }





    /* 조회 */

    @Test
    public void 카테고리별_조회() {

    }

    @Test
    public void 데이터셋_조회() {

    }

    @Test
    public void 데이터셋파일_조회() {

    }

}
