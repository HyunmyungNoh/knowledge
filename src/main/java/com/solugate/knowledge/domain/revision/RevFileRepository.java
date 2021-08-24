package com.solugate.knowledge.domain.revision;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevFileRepository extends JpaRepository<RevFile, Long> {
}
