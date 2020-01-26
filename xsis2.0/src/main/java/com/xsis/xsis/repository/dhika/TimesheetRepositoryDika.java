package com.xsis.xsis.repository.dhika;

import java.util.List;

import com.xsis.xsis.model.dhika.TimesheetDika;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * TimesheetRepository
 */
@Repository
public interface TimesheetRepositoryDika extends JpaRepository<TimesheetDika, Long> {

    // static final String clientname = "select b.id, c.name from x_timesheet a join
    // x_placement b on b.id = a.placement_id join x_client c on c.id = b.client_id
    // where b.is_placement_active = true and a.isdelete = false";

    @Override
    @Query(value = "SELECT * FROM x_timesheet WHERE isdelete = false ORDER BY timesheet_date", nativeQuery = true)
    List<TimesheetDika> findAll();

    @Query(value = "SELECT * FROM x_timesheet WHERE isdelete = false AND (CAST(timesheet_date as varchar) BETWEEN :sd AND :ed) ORDER BY timesheet_date", nativeQuery = true)
    List<TimesheetDika> searchTimesheet(@Param("sd") String startDate, @Param("ed") String endDate);

}