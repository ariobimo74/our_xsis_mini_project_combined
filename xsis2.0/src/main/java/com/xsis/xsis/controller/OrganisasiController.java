package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * OrganisasiController
 */
@Controller
@RequestMapping("/organisasi")
public class OrganisasiController {

    @GetMapping("/")
    public String getAll(Model model) {

        return "pages/vacancy";
    }

}