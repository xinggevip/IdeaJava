package com.gaoxing.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 如果在前面找不到异常处理，则找到这处理异常
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = Exception.class)
    public String doexception3(Exception ex){
        System.out.println("@ControllerAdvice-------------------");
        System.out.println(ex.getMessage());
        return "error";
    }
}
