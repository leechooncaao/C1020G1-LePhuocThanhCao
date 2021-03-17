package com.furama_app.controller;

import com.furama_app.model.contract.AttachService;
import com.furama_app.model.contract.Contract;
import com.furama_app.model.contract.ContractDetail;
import com.furama_app.model.customer.Customer;
import com.furama_app.model.employee.Employee;
import com.furama_app.model.service.Service;
import com.furama_app.service.attach_service.AttachServService;
import com.furama_app.service.contract.ContractService;
import com.furama_app.service.contract_detail.ContractDetailService;
import com.furama_app.service.customer.CustomerService;
import com.furama_app.service.employee.EmployeeService;
import com.furama_app.service.service_app.ServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachServService attachServService;

    @Autowired
    private ServService servService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute("listService")
    public List<Service> getListService(){
        return servService.findAll();
    }

    @ModelAttribute("listEmployee")
    public List<Employee> getListEmployee(){
        return employeeService.findAll();
    }

    @ModelAttribute("listCustomer")
    public List<Customer> getListCustomer(){
        return customerService.findAll();
    }

    @ModelAttribute("listAttachService")
    public List<AttachService> getListAttachService(){
        return attachServService.findAll();
    }

    @ModelAttribute("contractDetail")
    public ContractDetail getContractDetail(){
        return new ContractDetail();
    }

    @GetMapping("/list")
    public String getListContract(Model model){
        model.addAttribute("listContract", contractService.findAll());

        return "/contract/list";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable("id") Integer id, Model model){
        Contract contract = contractService.findById(id);

        List<ContractDetail> contractDetails = contractDetailService.findByContract_Id(contract.getId());

        model.addAttribute("contract", contract);
        model.addAttribute("listContractDetail",contractDetails);

        return "/contract/detail";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("contract", new Contract());

        return "/contract/create";
    }

    @PostMapping("/save")
    public String createContract(@Validated @ModelAttribute("contract") Contract contract,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 @RequestParam("Massage") Integer masQuantity,
                                 @RequestParam("Car rental") Integer carQuantity,
                                 @RequestParam("Food") Integer foodQuantity,
                                 @RequestParam("Beverage") Integer bevQuantity,
                                 @RequestParam("Karaoke") Integer karaQuantity){

        if (bindingResult.hasFieldErrors()) {
            return "/contract/create";
        }

        contractService.save(contract);

        if(masQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServService.findByName("Massage"),masQuantity));
        if(carQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServService.findByName("Car rental"),carQuantity));
        if(foodQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServService.findByName("Food"),foodQuantity));
        if(bevQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServService.findByName("Beverage"),bevQuantity));
        if(karaQuantity > 0)
            contractDetailService.save(new ContractDetail(contract, attachServService.findByName("Karaoke"),karaQuantity));

        redirectAttributes.addFlashAttribute("message", "Successfully created !");

        return "redirect:/contract/create";
    }








}
