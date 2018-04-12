package com.simbirsoft.javacourse.repository;

import com.simbirsoft.javacourse.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    List<Summary> findSummaryById(Long id);
}
