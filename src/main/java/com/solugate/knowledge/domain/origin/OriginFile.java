package com.solugate.knowledge.domain.origin;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORIGIN_FILE")
public class OriginFile {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OF_DIR")
    private String ofDir;

    @Column(name = "OF_WAV_NM")
    private String ofWavNm;

    @Column(name = "OF_WAV_SIZE")
    private Long ofWavSize;

    @Column(name = "Of_TXT_NM")
    private String ofTxtNm;

    @Column(name = "OF_TXT_SIZE")
    private Long ofTxtSize;

    @Column(name = "OF_META_NM")
    private String ofMetaNm;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "OD_ID")
    private Long odId;

    @Builder
    public OriginFile(Long id, String ofDir, String ofWavNm, Long ofWavSize,
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

    // 원본 데이터셋의 id 설정
    public void updateOdId(Long odId) {
        this.odId = odId;
    }
}
