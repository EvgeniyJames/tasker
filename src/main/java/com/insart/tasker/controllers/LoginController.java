package com.insart.tasker.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Evgeniy James
 * Date: 05.03.2015
 */
@Controller
public class LoginController {
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage(Model model){
        return "login";
    }
}
