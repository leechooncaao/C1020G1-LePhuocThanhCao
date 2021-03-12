package com.example.controller;

import com.example.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping(value = {"/", "welcome"})
    public String getWelcomePage(Model model){
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model, Principal principal){
        User loggedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loggedUser);

        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String getLogoutSuccessfulPage(Model model){
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @GetMapping("/userInfo")
    public String getUserInfoPage(Model model, Principal principal){
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loggedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loggedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @GetMapping("/403")
    public String getAccessDeniedPage(Model model, Principal principal){
        if (principal != null) {
            User loggedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loggedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }

}
