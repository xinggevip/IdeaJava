package com.juzimi.domain;

import java.util.Date;

public class SentencePro {
    private Integer sentenceId;

    private String sentenceTxt;

    private Integer albumId;

    private Integer classfiyId;

    private String authorName;

    private String userId;

    private Date createDate;

    private String albumName;

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
        this.sentenceTxt = sentenceTxt;
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
        this.authorName = authorName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "SentencePro{" +
                "sentenceId=" + sentenceId +
                ", sentenceTxt='" + sentenceTxt + '\'' +
                ", albumId=" + albumId +
                ", classfiyId=" + classfiyId +
                ", authorName='" + authorName + '\'' +
                ", userId='" + userId + '\'' +
                ", createDate=" + createDate +
                ", albumName='" + albumName + '\'' +
                '}';
    }
}
