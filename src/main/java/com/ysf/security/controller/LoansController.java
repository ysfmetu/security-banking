package com.ysf.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Created by yusufulku,18.05.2025 */
@RestController
public class LoansController {

    @GetMapping("/loans")
    public String getLoans() {
        return "Welcome to loans page";
    }

}

