package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sendtimesheet")
public class SendTimesheetController {
    @GetMapping
    public String TimesheetController() {
        return "pages/sendtimesheet";
    }
}
