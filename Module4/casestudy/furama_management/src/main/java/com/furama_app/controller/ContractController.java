package com.furama_app.controller;

import com.furama_app.model.contract.AttachService;
import com.furama_app.model.contract.Contract;
import com.furama_app.model.contract.ContractDetail;
import com.furama_app.model.service.Service;
import com.furama_app.service.attach_service.AttachServService;
import com.furama_app.service.contract.ContractService;
import com.furama_app.service.contract_detail.ContractDetailService;
import com.furama_app.service.service_app.ServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

    @ModelAttribute("listService")
    public List<Service> getListService(){
        return servService.findAll();
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




}
