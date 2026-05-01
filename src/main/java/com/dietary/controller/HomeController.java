package com.dietary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "<h1>Dietary Analysis Backend 🚀</h1>"
             + "<p>Project is deployed successfully.</p>"
             + "<p><b>Available APIs:</b></p>"
             + "<ul>"
             + "<li>POST /api/auth/register</li>"
             + "<li>POST /api/auth/login</li>"
             + "</ul>";
    }
}
