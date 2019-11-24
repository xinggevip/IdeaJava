package com.juzimi.domain;

public class CountResult {
    Integer allUsers;
    Integer todayRegUsers;
    Integer allSens;
    Integer todayPushSens;

    public CountResult(Integer allUsers, Integer todayRegUsers, Integer allSens, Integer todayPushSens) {
        this.allUsers = allUsers;
        this.todayRegUsers = todayRegUsers;
        this.allSens = allSens;
        this.todayPushSens = todayPushSens;
    }

    public Integer getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(Integer allUsers) {
        this.allUsers = allUsers;
    }

    public Integer getTodayRegUsers() {
        return todayRegUsers;
    }

    public void setTodayRegUsers(Integer todayRegUsers) {
        this.todayRegUsers = todayRegUsers;
    }

    public Integer getAllSens() {
        return allSens;
    }

    public void setAllSens(Integer allSens) {
        this.allSens = allSens;
    }

    public Integer getTodayPushSens() {
        return todayPushSens;
    }

    public void setTodayPushSens(Integer todayPushSens) {
        this.todayPushSens = todayPushSens;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "allUsers=" + allUsers +
                ", todayRegUsers=" + todayRegUsers +
                ", allSens=" + allSens +
                ", todayPushSens=" + todayPushSens +
                '}';
    }
}
