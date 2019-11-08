package com.juzimi.domain;

public class Album {
    private Integer albumId;

    private String albumName;

    private String albumDetails;

    private Integer classifyId;

    private String albumPicture;

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

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", albumDetails='" + albumDetails + '\'' +
                ", classifyId=" + classifyId +
                ", albumPicture='" + albumPicture + '\'' +
                '}';
    }

}