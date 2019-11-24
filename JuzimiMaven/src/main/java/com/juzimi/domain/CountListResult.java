package com.juzimi.domain;

import java.util.Date;

public class CountListResult {
    private Date date;
    private Integer usersCount;
    private Integer sensCount;

    public CountListResult(Date date, Integer usersCount, Integer sensCount) {
        this.date = date;
        this.usersCount = usersCount;
        this.sensCount = sensCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public Integer getSensCount() {
        return sensCount;
    }

    public void setSensCount(Integer sensCount) {
        this.sensCount = sensCount;
    }

    @Override
    public String toString() {
        return "CountListResult{" +
                "date=" + date +
                ", usersCount=" + usersCount +
                ", sensCount=" + sensCount +
                '}';
    }
}
