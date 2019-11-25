package com.juzimi.domain;

public class RequestByFirstPageDate {
    private String userId;
    private Integer pageNum;
    private Integer pageSize;
    private Integer albumId;
    private String keyy;

    public String getKeyy() {
        return keyy;
    }

    public void setKeyy(String keyy) {
        this.keyy = keyy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return "RequestByFirstPageDate{" +
                "userId='" + userId + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", albumId=" + albumId +
                ", keyy='" + keyy + '\'' +
                '}';
    }
}
