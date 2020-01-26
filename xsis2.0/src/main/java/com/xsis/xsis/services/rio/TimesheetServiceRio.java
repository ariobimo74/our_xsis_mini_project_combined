package com.xsis.xsis.services.rio;

import com.xsis.xsis.dto.rio.TimesheetDtoRio;
import com.xsis.xsis.model.rio.EmployeeEntityRio;
import com.xsis.xsis.model.rio.TimesheetEntityRio;
import com.xsis.xsis.repository.rio.EmployeeRepositoryRio;
import com.xsis.xsis.repository.rio.TimesheetRepositoryRio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TimesheetServiceRio
{
    @Autowired
    private TimesheetRepositoryRio timesheetRepository;

    @Autowired
    private EmployeeRepositoryRio employeeRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Iterable<TimesheetEntityRio> getTimesheetEntity()
    {
        List<TimesheetEntityRio> timesheetEntities = new ArrayList<>();
        for (TimesheetEntityRio timesheetEntity : timesheetRepository.findAll())
        {
            if (!timesheetEntity.getIsDelete())
            {
                timesheetEntities.add(timesheetEntity);
            }
        }
        return timesheetEntities;
    }

    public Optional<TimesheetEntityRio> findTimesheetById(Long timesheetId)
    {
        return timesheetRepository.findById(timesheetId);
    }

    public List<TimesheetDtoRio> getPlacementId(Long placementId)
    {
        return timesheetRepository.getPlacementId(placementId);
    }

    public List<TimesheetDtoRio> searchTimesheetDate(double stYear, double stMonth)
    {
        return timesheetRepository.searchTimesheetDate(stYear, stMonth);
    }

    public List<TimesheetDtoRio> searchTimesheetDateByPlacementId(Long placementId, double stYear, double stMonth)
    {
        return timesheetRepository.searchTimesheetDateByPlacementId(placementId, stYear, stMonth);
    }

    public TimesheetEntityRio updateTimesheet(TimesheetEntityRio timesheetEntity)
    {
        TimesheetEntityRio timesheet = timesheetRepository.findById(timesheetEntity.getId()).get();
        timesheet.setModifiedBy((long) 1);
        timesheet.setModifiedOn(new Date());
        timesheet.setSentOn(new Date());
        timesheet.setEroStatus("Sent");
        return timesheetRepository.save(timesheet);
    }

    public String sendTimesheet()
    {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        ArrayList<String> employeeEntities = new ArrayList<>();
        for(EmployeeEntityRio employeeEntity : employeeRepository.findAll())
        {
            if(employeeEntity.getEro())
            {
                employeeEntities.add(employeeEntity.getEroEmail());
            }
        }

        for(int i = 0; i < employeeEntities.size(); i++)
        {
            System.out.println(employeeEntities.get(i));

            simpleMailMessage.setTo(employeeEntities.get(i));
            simpleMailMessage.setSubject("Timesheet Submission");
            simpleMailMessage.setText("The timesheet has been sent! Thank you for your attention...");
            try {
                javaMailSender.send(simpleMailMessage);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
        return "email has been sent";
    }
}
