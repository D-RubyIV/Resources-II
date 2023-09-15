package com.poly.edu.controller;

import com.poly.edu.model.Product;
import com.poly.edu.reponsitory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public String getAll(Model model) {
        List<Product> listProduct = new ArrayList<>();
        listProduct = productRepository.findAll();
        model.addAttribute("listProduct", listProduct);
        return "admin/product/list-product";
    }

    @GetMapping("add-or-update")
    public String getAddOrUpdate(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "admin/product/add-or-update";
    }

    @PostMapping("add-or-update")
    public String postAddOrUpdate(@ModelAttribute("product") Product product,
            @RequestParam("formFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                byte[] imageBytes = file.getBytes();
                String imageData = Base64.getEncoder().encodeToString(imageBytes);
                product.setImage(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productRepository.save(product);
        return "redirect:/admin/product";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.get();
        productRepository.delete(product);
        return "redirect:/admin/product";
    }
}
