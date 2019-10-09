package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class User {
    private String username;
    private Integer age;
    private List hobby;
}
