package com.gaoxing.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Linkman {
    private Long link_id;
    private String link_name;
    private String link_gender;
    private String link_phone;
    private String link_mobile;
    private String link_email;
    private String link_qq;
    private String link_position;
    private String link_memo;
    private String link_cust_id;
    // 一个联系人只对一个客户
    private Customer customer;
}
