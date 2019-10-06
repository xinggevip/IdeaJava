package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @ToString
public class User {
    private Long user_id;
    private  String user_code;
    private String user_name;
    private String user_password;
    private String user_state;
    // 一个用户可以拥有多个角色
    private Set<Role> roles = new HashSet();

}
