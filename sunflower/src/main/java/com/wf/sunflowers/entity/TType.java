package com.wf.sunflowers.entity;

public class TType {
    private Integer tid;

    private String tname;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    @Override
    public String toString() {
        return "TType{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }
}