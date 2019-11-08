package com.juzimi.domain;

import org.springframework.stereotype.Service;

@Service
public class IsRegister {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "IsRegister{" +
                "state='" + state + '\'' +
                '}';
    }
}
