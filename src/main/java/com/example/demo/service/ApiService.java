package com.example.demo.service;

import com.example.demo.model.ApiRequest;
import com.example.demo.model.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    // 👉 Replace with your details
    private static final String FULL_NAME = "john_doe"; // lowercase
    private static final String DOB = "17091999"; // ddmmyyyy
    private static final String EMAIL = "john@xyz.com";
    private static final String ROLL_NUMBER = "ABCD123";

    // Helper: reverse + alternating caps
    private String alternateCaps(String input) {
        StringBuilder result = new StringBuilder();
        boolean upper = true;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                result.append(upper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                upper = !upper;
            }
        }
        return result.toString();
    }

    public ApiResponse processData(ApiRequest request) {
        ApiResponse response = new ApiResponse();

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialChars = new ArrayList<>();
        int sum = 0;

        if (request.getData() != null) {
            for (String item : request.getData()) {
                if (item.matches("-?\\d+")) { // ✅ numeric
                    int num = Integer.parseInt(item);
                    if (num % 2 == 0) {
                        evenNumbers.add(item); // keep as string
                    } else {
                        oddNumbers.add(item); // keep as string
                    }
                    sum += num;
                } else if (item.matches("[a-zA-Z]+")) { // ✅ alphabets
                    alphabets.add(item.toUpperCase());
                } else { // ✅ special characters
                    specialChars.add(item);
                }
            }
        }

        // join all alphabets together (uppercase), then alternate caps
        String concatString = alternateCaps(String.join("", alphabets));

        response.setIs_success(true);
        response.setUser_id(FULL_NAME + "_" + DOB);
        response.setEmail(EMAIL);
        response.setRoll_number(ROLL_NUMBER);
        response.setOdd_numbers(oddNumbers);
        response.setEven_numbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(specialChars);
        response.setSum(String.valueOf(sum)); // ✅ sum as string
        response.setConcat_string(concatString);

        return response;
    }
}
