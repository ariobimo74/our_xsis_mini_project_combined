package com.xsis.xsis.repository.eko;

import com.xsis.xsis.models.entity.ScheduleTypeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ScheduleTypeRepository
 */
@Repository
public interface ScheduleTypeRepository extends JpaRepository<ScheduleTypeEntity, Long> {

}