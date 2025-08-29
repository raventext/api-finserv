package com.example.demo.controller;

import com.example.demo.model.ApiRequest;
import com.example.demo.model.ApiResponse;
import com.example.demo.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping
    public ResponseEntity<ApiResponse> handleRequest(@RequestBody(required = false) ApiRequest request) {
        try {
            // if request is null or no data
            if (request == null || request.getData() == null) {
                ApiResponse errorResponse = new ApiResponse();
                errorResponse.setIs_success(false);
                errorResponse.setUser_id("john_doe_17091999"); // fallback required fields
                errorResponse.setEmail("john@xyz.com");
                errorResponse.setRoll_number("ABCD123");
                return ResponseEntity.badRequest().body(errorResponse);
            }

            ApiResponse response = apiService.processData(request);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            // catch unexpected errors gracefully
            ApiResponse errorResponse = new ApiResponse();
            errorResponse.setIs_success(false);
            errorResponse.setUser_id("john_doe_17091999");
            errorResponse.setEmail("john@xyz.com");
            errorResponse.setRoll_number("ABCD123");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
