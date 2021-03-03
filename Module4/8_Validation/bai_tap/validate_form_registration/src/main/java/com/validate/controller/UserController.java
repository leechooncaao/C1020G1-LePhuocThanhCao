package com.validate.controller;

import com.validate.model.User;
import com.validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());

        return "index";
    }

    @PostMapping("/validateUser")
    public ModelAndView validate(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("result");
        return modelAndView;
    }
}
