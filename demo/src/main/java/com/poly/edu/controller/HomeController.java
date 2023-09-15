package com.poly.edu.controller;


import com.poly.edu.model.Product;
import com.poly.edu.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public String home(Model model){
        List<Product> listProduct = new ArrayList<>();
        listProduct = productRepository.findAll();
        model.addAttribute("listProduct", listProduct);
        return "admin/home";
    }

}
