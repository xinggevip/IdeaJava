package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
    private Integer custId;
    private  String custName;
    private String custProfession;
    private String custPhone;
    private String email;
}
