package com.example.demo.controller;

import com.example.demo.model.ApiRequest;
import com.example.demo.model.ApiResponse;
import com.example.demo.service.ApiService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping
    public ApiResponse processData(@RequestBody ApiRequest request) {
        return apiService.processData(request);
    }

    @GetMapping
    public String healthCheck() {
        return "API is running ";
    }
}
