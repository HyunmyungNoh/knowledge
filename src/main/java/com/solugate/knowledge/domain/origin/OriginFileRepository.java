package com.solugate.knowledge.domain.origin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginFileRepository extends JpaRepository<OriginFile, Long> {
}
