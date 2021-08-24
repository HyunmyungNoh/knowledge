/* 파일 정보 받아올 때 */

package com.solugate.knowledge.controller.dto;

import com.solugate.knowledge.domain.origin.OriginDataset;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class FolderSaveDto {

    // 데이터셋 정보
    private Long id;
    private String odName;
    private String odDir;
    private String categoryCd;
    private Timestamp createDate;

    // 데이터 파일들
    private List<FileSaveDto> fileSaveDtos = new ArrayList<FileSaveDto>();

    @Builder
    public FolderSaveDto(Long id, String odName, String odDir, String categoryCd, Timestamp createDate,
                         List<FileSaveDto> fileSaveDtos) {
        this.id = id;
        this.odName = odName;
        this.odDir = odDir;
        this.categoryCd = categoryCd;
        this.createDate = createDate;
        this.fileSaveDtos = fileSaveDtos;
    }

    public OriginDataset toEntity() {
        return OriginDataset.builder()
            .id(id)
            .odName(odName)
            .odDir(odDir)
            .categoryCd(categoryCd)
            .createDate(createDate)
            .build();
    }
}
