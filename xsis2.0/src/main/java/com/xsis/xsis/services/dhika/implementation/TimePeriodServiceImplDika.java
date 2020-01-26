package com.xsis.xsis.services.dhika.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.xsis.xsis.model.dhika.TimePeriodDika;
import com.xsis.xsis.repository.dhika.TimePeriodRepositoryDika;
import com.xsis.xsis.services.dhika.TimePeriodServicesDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TimePeriodServiceImpl
 */
@Service
@Transactional
public class TimePeriodServiceImplDika implements TimePeriodServicesDika {

    @Autowired
    private TimePeriodRepositoryDika timePeriodRepository;

    @Override
    public List<TimePeriodDika> findAll() {
        List<TimePeriodDika> time = new ArrayList<>();
        for (TimePeriodDika tp : timePeriodRepository.findAll()) {
            if (!tp.getIsDelete()) {
                time.add(tp);
            }
        }
        return time;
    }

    @Override
    public Optional<TimePeriodDika> getById(Long id) {
        return timePeriodRepository.findById(id);
    }

    @Override
    public TimePeriodDika save(TimePeriodDika timePeriod) {
        timePeriod.setCreatedBy(2L);
        timePeriod.setCreatedOn(new Date());
        timePeriod.setIsDelete(false);
        return timePeriodRepository.save(timePeriod);
    }

    @Override
    public TimePeriodDika update(TimePeriodDika timePeriod) {
        TimePeriodDika tp = timePeriodRepository.findById(timePeriod.getId()).get();
        tp.setName(timePeriod.getName());
        tp.setDescription(timePeriod.getDescription());
        tp.setModifiedBy(2L);
        tp.setDeleteddOn(new Date());
        return timePeriodRepository.save(tp);
    }

    @Override
    public TimePeriodDika delete(Long id) {
        TimePeriodDika tp = timePeriodRepository.findById(id).get();
        tp.setIsDelete(true);
        tp.setDeletedBy(2L);
        tp.setDeleteddOn(new Date());
        return timePeriodRepository.save(tp);
    }

}