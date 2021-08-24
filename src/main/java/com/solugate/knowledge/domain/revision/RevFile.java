package com.solugate.knowledge.domain.revision;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "REVISION_FILE")
public class RevFile {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RF_DIR")
    private String rfDir;

    @Column(name = "RF_WAV_NM")
    private String rfWavNm;

    @Column(name = "RF_WAV_SIZE")
    private Long rfWavSize;

    @Column(name = "Rf_TXT_NM")
    private String rfTxtNm;

    @Column(name = "RF_TXT_SIZE")
    private Long rfTxtSize;

    @Column(name = "RF_META_NM")
    private String rfMetaNm;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "RD_ID")
    private Long rdId;

    @Builder
    public RevFile(Long id, String rfDir, String rfWavNm, Long rfWavSize,
                   String rfTxtNm, Long rfTxtSize, String rfMetaNm,
                   Timestamp createDate, Long rdId) {
        this.id = id;
        this.rfDir = rfDir;
        this.rfWavNm = rfWavNm;
        this.rfWavSize = rfWavSize;
        this.rfTxtNm = rfTxtNm;
        this.rfTxtSize = rfTxtSize;
        this.rfMetaNm = rfMetaNm;
        this.createDate = createDate;
        this.rdId = rdId;
    }

    public void updateRdId(Long rdId) {
        this.rdId = rdId;
    }
}
