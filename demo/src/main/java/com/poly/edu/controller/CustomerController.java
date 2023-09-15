package com.poly.edu.controller;


import com.poly.edu.model.Customer;
import com.poly.edu.model.Product;
import com.poly.edu.reponsitory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("admin/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("add-or-update")
    public String addCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "admin/customer/add-or-update";
    }

    @PostMapping("add-or-update")
    public String postAddOrUpdate(@ModelAttribute("customer") Customer customer){
        customerRepository.save(customer);
        return "redirect:/admin/product";
    }

}
