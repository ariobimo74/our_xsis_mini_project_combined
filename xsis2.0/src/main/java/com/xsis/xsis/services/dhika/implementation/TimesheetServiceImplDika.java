package com.xsis.xsis.services.dhika.implementation;

import java.util.*;

import com.xsis.xsis.model.dhika.TimesheetDika;
import com.xsis.xsis.repository.dhika.TimesheetRepositoryDika;
import com.xsis.xsis.services.dhika.TimesheetServiceDika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TimesheetServiceImpl
 */
@Service
public class TimesheetServiceImplDika implements TimesheetServiceDika {

    @Autowired
    private TimesheetRepositoryDika timesheetRepository;

    @Override
    public List<TimesheetDika> getAll() {
        List<TimesheetDika> timesheet = new ArrayList<>();
        for (TimesheetDika timesheets : timesheetRepository.findAll()) {
            if (!timesheets.getIsDelete()) {
                timesheet.add(timesheets);
            }
        }
        return timesheet;
    }

    @Override
    public Optional<TimesheetDika> getById(Long id) {
        return timesheetRepository.findById(id);
    }

    @Override
    public TimesheetDika save(TimesheetDika timesheet) {
        timesheet.setCreatedOn(new Date());
        timesheet.setSubmittedOn(new Date());
        timesheet.setCreatedBy(2L);
        timesheet.setIsDelete(false);
        return timesheetRepository.save(timesheet);
    }

    @Override
    public TimesheetDika update(TimesheetDika timesheet) {
        TimesheetDika timesheetedit = timesheetRepository.findById(timesheet.getId()).get();
        timesheetedit.setStatus(timesheet.getStatus());
        timesheetedit.setPlacementId(timesheet.getPlacementId());
        timesheetedit.setTimesheetDate(timesheet.getTimesheetDate());
        timesheetedit.setStart(timesheet.getStart());
        timesheetedit.setEndTime(timesheet.getEndTime());
        timesheetedit.setOvertime(timesheet.getOvertime());
        timesheetedit.setStartOt(timesheet.getStartOt());
        timesheetedit.setEndOt(timesheet.getEndOt());
        timesheetedit.setActivity(timesheet.getActivity());
        timesheetedit.setUserApproval(timesheet.getUserApproval());
        timesheetedit.setSubmittedOn(new Date());
        timesheetedit.setApprovedOn(timesheet.getApprovedOn());
        timesheetedit.setEroStatus(timesheet.getEroStatus());
        timesheetedit.setSentOn(timesheet.getSentOn());
        timesheetedit.setCollectedOn(timesheet.getCollectedOn());
        timesheetedit.setModifiedBy(2L);
        timesheetedit.setModifiedOn(new Date());

        return timesheetRepository.save(timesheetedit);
    }

    @Override
    public TimesheetDika delete(Long id) {
        TimesheetDika timesheetEntity = timesheetRepository.findById(id).get();
        timesheetEntity.setIsDelete(true);
        timesheetEntity.setDeletedBy(2L);
        timesheetEntity.setDeleteddOn(new Date());
        return timesheetRepository.save(timesheetEntity);
    }

    @Override
    public List<TimesheetDika> getResultSearchDateTimesheet(String startDate, String endDate) {
        return timesheetRepository.searchTimesheet(startDate, endDate);
    }

    // @Override
    // public List<Timesheet> getName() {

    // return timesheetRepository.getNameClient();
    // }

}