package com.juzimi.domain;

import java.io.Serializable;


public class Result implements Serializable {

    //判断结果
    private boolean success;
    //返回信息
    private String message;
    // 返回创建的专辑id
    private Integer albumId;

    public Result(boolean success, String message,Integer albumId) {
        this.success = success;
        this.message = message;
        this.albumId = albumId;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", albumId=" + albumId +
                '}';
    }
}