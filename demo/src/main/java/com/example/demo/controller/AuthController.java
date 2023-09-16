package com.example.demo.controller;

import com.example.demo.dto.auth.AuthDto;
import com.example.demo.impl.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthDto authDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        else {
            return userEntityService.login(authDto);
        }

    }
}
