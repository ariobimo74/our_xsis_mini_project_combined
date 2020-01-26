package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timesheetapproval")
public class ApprovalTimesheetController {

    @GetMapping("/")
    public String showTimesheet(Model model) {
        return "pages/timesheetapproval";
    }
}