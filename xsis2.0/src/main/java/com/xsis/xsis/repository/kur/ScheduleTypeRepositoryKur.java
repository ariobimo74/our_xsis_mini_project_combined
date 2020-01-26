package com.xsis.xsis.repository.kur;

import java.util.List;

import com.xsis.xsis.model.kur.ScheduleTypeKur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScheduleTypeRepositoryKur extends JpaRepository<ScheduleTypeKur, Long> {
    @Query(value = "select * from x_schedule_type WHERE id = ?1", nativeQuery = true)
    List<ScheduleTypeKur> getScheduleTypeId(Long id);

}