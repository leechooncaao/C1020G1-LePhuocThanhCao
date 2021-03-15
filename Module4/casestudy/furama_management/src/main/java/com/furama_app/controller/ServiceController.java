package com.furama_app.controller;

import com.furama_app.model.customer.Customer;
import com.furama_app.model.service.Service;
import com.furama_app.service.service_app.ServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServService servService;

    @GetMapping("/list")
    public String getListService(Model model){
        List<Service> services = servService.findAll();
        model.addAttribute("listService", services);

        return "/service/list";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("service", new Service());

        return "/service/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute("service") Service service, RedirectAttributes redirectAttributes){
        servService.save(service);
        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/service/create";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model){
        Service service = servService.findById(id);
        model.addAttribute("service", service);

        return "/service/edit";
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("service") Service service, Model model){
        servService.save(service);
        model.addAttribute("message", "Successfully updated !");

        return "/service/edit";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id){
        servService.delete(servService.findById(id));

        return "redirect:/service/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") String input, Model model){
        List<Service> services =  servService.findAllByNameContaining(input);

        if(services.isEmpty())
            return "notFound";
        else {
            model.addAttribute("listService", services);
            return "/service/list";
        }

    }

}
