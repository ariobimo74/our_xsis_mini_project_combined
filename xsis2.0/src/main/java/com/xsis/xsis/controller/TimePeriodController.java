package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TimePeriod
 */
@Controller
@RequestMapping("/time")
public class TimePeriodController {

    @GetMapping("/")
    public String showTime(Model model){
        return "pages/timeperiod";
    }

    
}