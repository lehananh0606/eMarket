package com.example.emarket.exceptions;

public class UserNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "User not found";
    }
}
