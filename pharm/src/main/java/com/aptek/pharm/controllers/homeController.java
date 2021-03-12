package com.aptek.pharm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class homeController {

@RequestMapping("/")
    public String home(){
        return "index";

    }

    @RequestMapping("/salam")
    public String salam(ModelMap modelMap){
        modelMap.addAttribute("salam","Salam Dunya ***************************");
        modelMap.addAttribute("qehremanlar","qehremanlar olmur ****************qehremanlar yasayir***********");

        return "salam";

    }





}
