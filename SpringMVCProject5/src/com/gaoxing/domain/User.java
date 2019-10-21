package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;


@Getter @Setter @ToString
public class User {
    @NotBlank
    private String username;
    @NotBlank
    @Max(value = 200,message = "年龄不合法")
    private String age;
    private Integer gender;
    private String[] hobby;
    private Pet pet;
}
