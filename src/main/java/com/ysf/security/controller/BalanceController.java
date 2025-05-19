package com.ysf.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Created by yusufulku,18.05.2025 */
@RestController
public class BalanceController {

    @GetMapping("/myBalance")
    public String getBalanceDetail() {
        return "this balance detail info is retrieved by DB";
    }

}

