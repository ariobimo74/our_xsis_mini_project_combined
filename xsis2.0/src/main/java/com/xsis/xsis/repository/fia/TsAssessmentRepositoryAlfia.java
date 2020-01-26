package com.xsis.xsis.repository.fia;

import com.xsis.xsis.model.fia.TsAssessmentAlfia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TsAssessmentRepositoryAlfia extends JpaRepository<TsAssessmentAlfia, Long> {

}