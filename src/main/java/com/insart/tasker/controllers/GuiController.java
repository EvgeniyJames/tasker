package com.insart.tasker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: Evgeniy James
 * Date: 23.02.2015
 */
@Controller
public class GuiController {
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
