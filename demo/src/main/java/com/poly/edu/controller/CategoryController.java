package com.poly.edu.controller;


import com.poly.edu.model.Category;
import com.poly.edu.reponsitory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("")
    public String getAll(Model model){
        List<Category> listCategory = new ArrayList<>();
        listCategory = categoryRepository.findAll();
        model.addAttribute("listCategory", listCategory);
        return "admin/category/list-category";
    }

    @GetMapping("add-or-update")
    public String getAddOrUpdate(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/category/add-or-update";
    }


    @PostMapping("add-or-update")
    public String postAddOrUpdate(@ModelAttribute("category") Category category){
        categoryRepository.save(category);
        return "redirect:/admin/category";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = optional.get();
        categoryRepository.delete(category);
        return "redirect:/admin/category";
    }

}
