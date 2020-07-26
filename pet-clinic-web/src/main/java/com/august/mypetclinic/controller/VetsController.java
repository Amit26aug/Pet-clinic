package com.august.mypetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("vets")
@Controller
public class VetsController {

    @RequestMapping({"", "/", "index", "list"})
    public String index() {
        return "vets/index";
    }

}
