package com.gaoxing.demo2;

import lombok.Setter;
import lombok.ToString;

@Setter @ToString
public class Person {
    public String name;

    public void init(){
        System.out.println("init");
    }
    public void destroy(){
        System.out.println("destroy");
    }

}
