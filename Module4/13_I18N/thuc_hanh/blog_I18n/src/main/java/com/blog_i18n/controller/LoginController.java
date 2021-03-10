package com.blog_i18n.controller;

import com.blog_i18n.model.Credential;
import com.blog_i18n.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    @ModelAttribute("user")
    public User setUpUser(){
        return new User();
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("credential", new Credential());
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential") Credential credential, Model model, @ModelAttribute("user") User user) {
        user.setUserName(credential.getUsername());
        return "dashboard";
    }
}
