package com.xsis.xsis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ReligionController
 */
@Controller
@RequestMapping("/religion")
public class ReligionController {

    @GetMapping("/")
    public String showReligion(Model model) {
        return "pages/religion";
    }

}