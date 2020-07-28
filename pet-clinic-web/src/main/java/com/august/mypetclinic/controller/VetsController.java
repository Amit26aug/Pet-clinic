package com.august.mypetclinic.controller;

import com.august.mypetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vets")
@Controller
public class VetsController {

    private final VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/", "index", "list"})
    public String index(Model model) {
        model.addAttribute("vets", vetService.finAll());
        return "vets/index";
    }

}
