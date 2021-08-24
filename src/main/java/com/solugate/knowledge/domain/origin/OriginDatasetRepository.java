package com.solugate.knowledge.domain.origin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OriginDatasetRepository extends JpaRepository<OriginDataset, Long> {

    List<OriginDataset> findAllByCategoryCd(String categoryCd);
}
