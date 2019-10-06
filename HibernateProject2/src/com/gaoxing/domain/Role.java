package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @ToString
public class Role {
    private Long role_id;
    private String role_name;
    private String role_memo;
    private Set<User> users = new HashSet<>();
}
