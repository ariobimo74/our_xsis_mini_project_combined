package com.xsis.xsis.services.fia.Implement;

import java.util.*;

import javax.transaction.Transactional;

import com.xsis.xsis.dto.fia.TimesheetPlaDtoAlfia;
import com.xsis.xsis.model.fia.TimesheetAlfia;
import com.xsis.xsis.repository.fia.TimesheetAproveRepositoryAlfia;
import com.xsis.xsis.services.fia.TimesheetServiceAlfia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TimesheetServiceImp
 */
@Service
@Transactional
public class TimesheetServiceImpAlfia implements TimesheetServiceAlfia {

    @Autowired
    private TimesheetAproveRepositoryAlfia timesheetAproveRepository;

    @Override
    public TimesheetAlfia getById(Long id) {
        return timesheetAproveRepository.findById(id).get();
    }

    @Override
    public TimesheetPlaDtoAlfia findByIdTS(Long id) {
        return timesheetAproveRepository.findByIdTS(id);
    }

    @Override
    public List<TimesheetAlfia> getAll() {
        List<TimesheetAlfia> ts = new ArrayList<>();
        for (TimesheetAlfia tss : timesheetAproveRepository.findAll()) {
            if (!tss.getIsDelete()) {
                ts.add(tss);
            }
        }
        return ts;
    }

    @Override
    public List<TimesheetPlaDtoAlfia> joinTimesheet() {
        return timesheetAproveRepository.joinTimesheet();
    }

    @Override
    public List<TimesheetPlaDtoAlfia> searchTimesheet(String timesheetDate) {
        return timesheetAproveRepository.searchTimesheet(timesheetDate);
    }

    @Override
    public TimesheetAlfia tolakTs(Long id) {
        TimesheetAlfia ts = timesheetAproveRepository.findById(id).get();
        ts.setUserApproval("rejected");
        ts.setModifiedBy(2L);
        ts.setModifiedOn(new Date());
        return timesheetAproveRepository.save(ts);
    }

    @Override
    public TimesheetAlfia setujui(Long id) {
        TimesheetAlfia ts = timesheetAproveRepository.findById(id).get();
        ts.setUserApproval("approved");
        ts.setApprovedOn(new Date());
        ts.setModifiedBy(2L);
        ts.setModifiedOn(new Date());
        return timesheetAproveRepository.save(ts);
    }
}