package com.wf.sunflowers.domain;

public class ResultInfo {
    private Boolean success;
    private String message;

    public ResultInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
