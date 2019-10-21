package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class User {
    private String username;
    private String age;
    private Integer gender;
    private String[] hobby;
    private Pet pet;
}
