package com.juzimi.domain;

import java.util.Date;

public class Sentence {
    private Integer sentenceId;

    private String sentenceTxt;

    private Integer albumId;

    private Integer classfiyId;

    private String authorName;

    private String userId;

    private Date createDate;

    public Integer getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    public String getSentenceTxt() {
        return sentenceTxt;
    }

    public void setSentenceTxt(String sentenceTxt) {
        this.sentenceTxt = sentenceTxt == null ? null : sentenceTxt.trim();
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getClassfiyId() {
        return classfiyId;
    }

    public void setClassfiyId(Integer classfiyId) {
        this.classfiyId = classfiyId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}