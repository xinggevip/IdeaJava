package com.juzimi.domain;

public class Userlikesen {
    private Integer userLikesenId;

    private String userId;

    private Integer sentenceId;

    public Integer getUserLikesenId() {
        return userLikesenId;
    }

    public void setUserLikesenId(Integer userLikesenId) {
        this.userLikesenId = userLikesenId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    @Override
    public String toString() {
        return "Userlikesen{" +
                "userLikesenId=" + userLikesenId +
                ", userId='" + userId + '\'' +
                ", sentenceId=" + sentenceId +
                '}';
    }
}