package com.xsis.xsis.repository.fia;

import java.util.List;

import com.xsis.xsis.dto.fia.TimesheetPlaDtoAlfia;
import com.xsis.xsis.model.fia.TimesheetAlfia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TimesheetAproveRepository
 */
@Repository
public interface TimesheetAproveRepositoryAlfia extends JpaRepository<TimesheetAlfia, Long> {
    @Query(nativeQuery = true)
    List<TimesheetPlaDtoAlfia> joinTimesheet();

    @Query(nativeQuery = true)
    List<TimesheetPlaDtoAlfia> searchTimesheet(@Param("yearmonth") String timesheetDate);

    @Query(nativeQuery = true)
    TimesheetPlaDtoAlfia findByIdTS(@Param("idsearch") Long id);

}