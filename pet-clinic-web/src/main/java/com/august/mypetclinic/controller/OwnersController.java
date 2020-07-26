package com.august.mypetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("owners")
@Controller
public class OwnersController {

    @RequestMapping({"", "/", "index", "list"})
    public String index() {
        return "owners/index";
    }

}
