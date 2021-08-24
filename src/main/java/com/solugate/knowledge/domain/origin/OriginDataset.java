package com.solugate.knowledge.domain.origin;

import com.solugate.knowledge.domain.revision.RevDataset;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ORIGIN_DATASET")
public class OriginDataset {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "OD_NM")
    private String odName;

    @Column(name = "OD_DIR")
    private String odDir;

    @Column(name = "CATEGORY_CD")
    private String categoryCd;

    /*
    2. TimeStamp로 현재시간을 구해서 DB에 insert 하려면 아래의 방법을 이용
    (1) LocalDateTime.now() 로 현재시간을 구하고
    (2) localDateTimeToTimeStamp() 함수로 타입 변환하여 DB에 insert하면 된다.
    혹은 나중에 받아올 때 다음과 같이 지정
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp createdDatetime;
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "OD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<OriginFile> originFileList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "OD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<RevDataset> revDatasetList;

    @Builder
    public OriginDataset(Long id, String odName, String odDir, String categoryCd, Timestamp createDate) {
        this.id = id;
        this.odName = odName;
        this.odDir = odDir;
        this.categoryCd = categoryCd;
        this.createDate = createDate;
    }
}