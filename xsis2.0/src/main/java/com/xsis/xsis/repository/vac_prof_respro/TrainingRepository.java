package com.xsis.xsis.repository.vac_prof_respro;

import java.util.List;

import com.xsis.xsis.dto.vac_prof_respro.TraiDto;
import com.xsis.xsis.model.vac_prof_respro.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * TrainingRepository
 */
public interface TrainingRepository extends JpaRepository<Training, Long>{

    @Query(nativeQuery = true)
    List<TraiDto> getTrainingBiodata(Long biodataId);
    
}