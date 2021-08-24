package com.solugate.knowledge.controller.dto;

import com.solugate.knowledge.domain.origin.OriginDataset;
import com.solugate.knowledge.domain.revision.RevDataset;
import lombok.Builder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RevSaveDto {

    // 데이터셋 정보
    private Long id;
    private String rdName;
    private String rdDir;
    private String categoryCd;
    private Timestamp createDate;

    // 데이터 파일들
    private List<RevFileSaveDto> revFileDtos = new ArrayList<RevFileSaveDto>();

    @Builder
    public RevSaveDto(Long id, String rdName, String rdDir, String categoryCd, Timestamp createDate,
                         List<RevFileSaveDto> revFileDtos) {
        this.id = id;
        this.rdName = rdName;
        this.rdDir = rdDir;
        this.categoryCd = categoryCd;
        this.createDate = createDate;
        this.revFileDtos = revFileDtos;
    }


    public RevDataset toEntity() {
        return RevDataset.builder()
                .id(id)
                .rdName(rdName)
                .rdDir(rdDir)
                .categoryCd(categoryCd)
                .createDate(createDate)
                .build();
    }
}
