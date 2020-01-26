package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PermissionController
 */
@Controller
@RequestMapping("/timesheet")
public class TimesheetController {

    @GetMapping
    public String showPermissionHistory(Model model) {
        return "pages/timesheet";
    }

}