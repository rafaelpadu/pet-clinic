package com.example.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index.html"})
    public String index(Model model){
        model.addAttribute("welcome", "BEm Vindo");
        return "index";
    };

    @RequestMapping("/oups")
    public String oupsError(){
        return "notimplemented";
    }
}
