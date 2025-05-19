package com.ysf.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/* Created by yusufulku,18.05.2025 */
@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCardsDetail() {
        return "this cards detail info is retrieved by DB";
    }

}

