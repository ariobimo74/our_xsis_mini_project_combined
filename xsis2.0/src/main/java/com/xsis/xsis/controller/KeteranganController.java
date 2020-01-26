package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * KeteranganController
 */
@Controller
@RequestMapping("/keterangan")
public class KeteranganController {
    @GetMapping
    public String keterangan(){
        return "pages/keterangan";
    }
    
}