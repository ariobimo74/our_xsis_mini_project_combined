package com.xsis.xsis.services.kur.Implementation;

import java.util.List;

import javax.transaction.Transactional;

import com.xsis.xsis.model.kur.ScheduleTypeKur;
import com.xsis.xsis.repository.kur.ScheduleTypeRepositoryKur;
import com.xsis.xsis.services.kur.ScheduleTypeServiceKur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ScheduleTypeServiceImplKur implements ScheduleTypeServiceKur {

    @Autowired
    private ScheduleTypeRepositoryKur scheduleTypeRepository;

    @Override
    public List<ScheduleTypeKur> getScheduleType() {
        return scheduleTypeRepository.findAll();
    }

    @Override
    public List<ScheduleTypeKur> getScheduleTypeId(Long id) {
        return scheduleTypeRepository.getScheduleTypeId(id);
    }

    @Override
    public ScheduleTypeKur getById(Long id) {
        return scheduleTypeRepository.findById(id).get();
    }

}