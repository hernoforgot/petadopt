package com.example.petadopt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: petadopt
 * @package: com.example.petadopt.controller
 * @className: WelcomeController
 * @author: sxl
 * @description: TODO
 * @date: 2023/9/18 21:34
 * @version: 1.0
 */
@Controller
public class WelcomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
