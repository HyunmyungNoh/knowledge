package com.solugate.knowledge.controller.dto;

import com.solugate.knowledge.domain.origin.OriginFile;
import com.solugate.knowledge.domain.revision.RevFile;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
public class FileSaveDto {

    private Long id;
    private String ofDir;
    private String ofWavNm;
    private Long ofWavSize;
    private String ofTxtNm;
    private Long ofTxtSize;
    private String ofMetaNm;
    private Timestamp createDate;
    private Long odId;

    @Builder
    public FileSaveDto(Long id, String ofDir, String ofWavNm, Long ofWavSize,
                       String ofTxtNm, Long ofTxtSize, String ofMetaNm, Timestamp createDate, Long odId) {
        this.id = id;
        this.ofDir = ofDir;
        this.ofWavNm = ofWavNm;
        this.ofWavSize = ofWavSize;
        this.ofTxtNm = ofTxtNm;
        this.ofTxtSize = ofTxtSize;
        this.ofMetaNm = ofMetaNm;
        this.createDate = createDate;
        this.odId = odId;
    }

    public OriginFile toOrigEntity() {
        return OriginFile.builder()
            .id(id)
            .ofDir(ofDir)
            .ofWavNm(ofWavNm)
            .ofWavSize(ofWavSize)
            .ofTxtNm(ofTxtNm)
            .ofTxtSize(ofTxtSize)
            .ofMetaNm(ofMetaNm)
            .createDate(createDate)
            .odId(odId)
            .build();
    }

    public RevFile toRevEntity() {
        return RevFile.builder()
                .id(id)
                .rfDir(ofDir)
                .rfWavNm(ofWavNm)
                .rfWavSize(ofWavSize)
                .rfTxtNm(ofTxtNm)
                .rfTxtSize(ofTxtSize)
                .rfMetaNm(ofMetaNm)
                .createDate(createDate)
                .rdId(odId)
                .build();
    }
}
