package com.example.demo.service;

import com.example.demo.model.ApiRequest;
import com.example.demo.model.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    public ApiResponse processData(ApiRequest request) {
        ApiResponse response = new ApiResponse();

        try {
            List<String> data = request.getData();

            String username = data.size() > 0 ? data.get(0).toLowerCase() : "unknown_user";
            String email = data.size() > 1 ? data.get(1) : "unknown_email";
            String rollNumber = data.size() > 2 ? data.get(2) : "unknown_roll";

            response.setUserId(username);
            response.setEmail(email);
            response.setRollNumber(rollNumber);

            List<String> oddNumbers = new ArrayList<>();
            List<String> evenNumbers = new ArrayList<>();
            List<String> alphabets = new ArrayList<>();
            List<String> specialChars = new ArrayList<>();
            int sum = 0;
            List<String> alphaOriginalOrder = new ArrayList<>();

            for (int i = 3; i < data.size(); i++) {
                String item = data.get(i);
                if (item.matches("\\d+")) {
                    int num = Integer.parseInt(item);
                    sum += num;
                    if (num % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } else if (item.matches("[a-zA-Z]")) {
                    alphabets.add(item.toUpperCase());
                    alphaOriginalOrder.add(item);
                } else {
                    specialChars.add(item);
                }
            }

            response.setOddNumbers(oddNumbers);
            response.setEvenNumbers(evenNumbers);
            response.setAlphabets(alphabets);
            response.setSpecialCharacters(specialChars);
            response.setSum(String.valueOf(sum));

            String concatString = buildAlternatingCaps(alphaOriginalOrder);
            response.setConcatString(concatString);

            response.setSuccess(true);

        } catch (Exception e) {
            response.setSuccess(false);
            response.setUserId("error_user");
            response.setEmail("error_email");
            response.setRollNumber("error_roll");
        }

        return response;
    }

    private String buildAlternatingCaps(List<String> alphabets) {
        StringBuilder sb = new StringBuilder();
        int toggle = 0;
        for (String alpha : alphabets) {
            String ch = alpha.toLowerCase();
            if (toggle % 2 == 0) {
                sb.append(ch.toUpperCase());
            } else {
                sb.append(ch.toLowerCase());
            }
            toggle++;
        }
        return sb.toString();
    }
}
