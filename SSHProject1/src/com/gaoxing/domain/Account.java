package com.gaoxing.domain;

public class Account {
    private  String name;
    private Double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "naem='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
