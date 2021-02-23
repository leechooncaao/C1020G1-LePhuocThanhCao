package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    @RequestMapping("/")
    public String getHome(Model model){
        model.addAttribute("email", new Email());
        return "/home";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("email") Email email, Model model){
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("spamsFilter", email.isSpamsFilter());
        model.addAttribute("signature", email.getSignature());

        return "/result";

    }

}
