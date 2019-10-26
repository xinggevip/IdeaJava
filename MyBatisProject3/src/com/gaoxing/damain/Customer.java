package com.gaoxing.damain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer {
    private Integer cust_ids;
    private  String cust_names;
    private String cust_professions;
    private String cust_phones;
    private String email;
}
