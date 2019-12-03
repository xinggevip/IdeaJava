package com.wf.sunflowers.entity;

import java.util.Date;

public class TFlagPro {
    private Integer fid;

    private String hname;

    private Integer typeid;

    private Date hdate;

    private String implement;

    private String word;

    private Integer userid;

    private Integer click;

    private String tname;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Date getHdate() {
        return hdate;
    }

    public void setHdate(Date hdate) {
        this.hdate = hdate;
    }

    public String getImplement() {
        return implement;
    }

    public void setImplement(String implement) {
        this.implement = implement;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "TFlagPro{" +
                "fid=" + fid +
                ", hname='" + hname + '\'' +
                ", typeid=" + typeid +
                ", hdate=" + hdate +
                ", implement='" + implement + '\'' +
                ", word='" + word + '\'' +
                ", userid=" + userid +
                ", click=" + click +
                ", tname='" + tname + '\'' +
                '}';
    }
}
