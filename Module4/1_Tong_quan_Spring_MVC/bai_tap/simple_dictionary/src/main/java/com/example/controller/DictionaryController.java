package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping({"", "/search"})
    public String search(@RequestParam String enteredWord, Model model){
        String result = dictionaryService.search(enteredWord);
        model.addAttribute("result",result);
        model.addAttribute("enterWord",enteredWord);

        return "/result";
    }
}
