package com.solugate.knowledge.domain.revision;

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
@Table(name = "REVISION_DATASET")
public class RevDataset {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RD_NM")
    private String rdName;

    @Column(name = "RD_DIR")
    private String rdDir;

    @Column(name = "CATEGORY_CD")
    private String categoryCd;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "OD_ID")
    private Long odId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "RD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    private List<RevFile> revFileList;

    @Builder
    public RevDataset(Long id, String rdName, String rdDir, String categoryCd, Timestamp createDate, Long odId) {
        this.id = id;
        this.rdName = rdName;
        this.rdDir = rdDir;
        this.categoryCd = categoryCd;
        this.createDate = createDate;
        this.odId = odId;
    }

    public void updateCategory(String categoryCd) {
        this.categoryCd = categoryCd;
    }
}
