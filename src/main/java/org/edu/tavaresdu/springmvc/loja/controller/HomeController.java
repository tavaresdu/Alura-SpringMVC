package org.edu.tavaresdu.springmvc.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public void index() {
        System.out.println("Home");
    }
}
