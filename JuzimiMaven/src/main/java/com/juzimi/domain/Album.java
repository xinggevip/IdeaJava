package com.juzimi.domain;

import java.util.Date;

public class Album {
    private Integer albumId;

    private String albumName;

    private String albumDetails;

    private Integer classifyId;

    private String albumPicture;

    private String userId;

    private Date createDate;

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
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumDetails() {
        return albumDetails;
    }

    public void setAlbumDetails(String albumDetails) {
        this.albumDetails = albumDetails == null ? null : albumDetails.trim();
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getAlbumPicture() {
        return albumPicture;
    }

    public void setAlbumPicture(String albumPicture) {
        this.albumPicture = albumPicture == null ? null : albumPicture.trim();
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