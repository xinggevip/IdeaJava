package com.juzimi.domain;

import java.util.Date;

public class FirstPageData {
    private Integer sentenceId;

    private String sentenceTxt;

    private Integer albumId;
    private String albumName;

    private Integer classfiyId;
    private String classifyName;

    private String authorName;

    private String userId;

    private Date createDate;

    private String userPicture;

    private Integer isLike;

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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Integer getClassfiyId() {
        return classfiyId;
    }

    public void setClassfiyId(Integer classfiyId) {
        this.classfiyId = classfiyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
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

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    @Override
    public String toString() {
        return "FirstPageData{" +
                "sentenceId=" + sentenceId +
                ", sentenceTxt='" + sentenceTxt + '\'' +
                ", albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", classfiyId=" + classfiyId +
                ", classifyName='" + classifyName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", userId='" + userId + '\'' +
                ", createDate=" + createDate +
                ", userPicture='" + userPicture + '\'' +
                ", isLike=" + isLike +
                '}';
    }
}
