package com.august.mypetclinic.controller;

import com.august.mypetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "index", "list"})
    public String index(Model model) {
        model.addAttribute("owners", ownerService.finAll());
        return "owners/index";
    }

}
