package com.examine.demo.controller;

import com.examine.demo.entity.Contract;
import com.examine.demo.entity.Customer;
import com.examine.demo.service.ContractService;
import com.examine.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute("listCustomer")
    public List<Customer> getListCustomer(){
        return customerService.findAll();
    }

    @GetMapping("/list")
    public String getListContract(Model model){
        model.addAttribute("listContract", contractService.findAll());

        return "list";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("contract", new Contract());

        return "create";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
//
//        Boolean isValidDate = contractService.isValidDate(contract.getDate());
//        if (!isValidDate)
//            redirectAttributes.addFlashAttribute("validDate", "Date is wrong format");
//        else {
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("message", "Successfully created !");
//        }

        return "redirect:/contract/create";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable("id") Integer id, Model model){
        Contract contract = contractService.findById(id);

        model.addAttribute("contract", contract);
        return "detail";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") Integer id) {
        contractService.delete(contractService.findById(id));

        return "redirect:/contract/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search-data") String input, Model model, @RequestParam("serviceType") String serviceType) {
        model.addAttribute("listContract", contractService.findAllByCustomer_NameContaining(input));
        return "list";

    }
}
