package com.keneth.hotel.controllers;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        System.out.println(ex.getMessage());
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
}

