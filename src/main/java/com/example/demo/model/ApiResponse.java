package com.example.demo.model;

import java.util.List;

public class ApiResponse {
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<String> odd_numbers;
    private List<String> even_numbers;
    private List<String> alphabets;
    private List<String> special_characters;
    private String sum;
    private String concat_string;

    public boolean isSuccess() {
        return is_success;
    }

    public void setSuccess(boolean success) {
        is_success = success;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNumber() {
        return roll_number;
    }

    public void setRollNumber(String roll_number) {
        this.roll_number = roll_number;
    }

    public List<String> getOddNumbers() {
        return odd_numbers;
    }

    public void setOddNumbers(List<String> odd_numbers) {
        this.odd_numbers = odd_numbers;
    }

    public List<String> getEvenNumbers() {
        return even_numbers;
    }

    public void setEvenNumbers(List<String> even_numbers) {
        this.even_numbers = even_numbers;
    }

    public List<String> getAlphabets() {
        return alphabets;
    }

    public void setAlphabets(List<String> alphabets) {
        this.alphabets = alphabets;
    }

    public List<String> getSpecialCharacters() {
        return special_characters;
    }

    public void setSpecialCharacters(List<String> special_characters) {
        this.special_characters = special_characters;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getConcatString() {
        return concat_string;
    }

    public void setConcatString(String concat_string) {
        this.concat_string = concat_string;
    }
}
