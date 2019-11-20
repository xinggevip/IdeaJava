package com.juzimi.domain;

public class Admin {
    private String adminId;

    private String adminPassword;

    private Integer isOpenActive;

    private String adminPicture;

    private String adminOtherOne;

    private String adminOtherTwo;

    private String adminOtherThree;

    private String adminOtherFour;

    private String adminOtherFive;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId == null ? null : adminId.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public Integer getIsOpenActive() {
        return isOpenActive;
    }

    public void setIsOpenActive(Integer isOpenActive) {
        this.isOpenActive = isOpenActive;
    }

    public String getAdminPicture() {
        return adminPicture;
    }

    public void setAdminPicture(String adminPicture) {
        this.adminPicture = adminPicture == null ? null : adminPicture.trim();
    }

    public String getAdminOtherOne() {
        return adminOtherOne;
    }

    public void setAdminOtherOne(String adminOtherOne) {
        this.adminOtherOne = adminOtherOne == null ? null : adminOtherOne.trim();
    }

    public String getAdminOtherTwo() {
        return adminOtherTwo;
    }

    public void setAdminOtherTwo(String adminOtherTwo) {
        this.adminOtherTwo = adminOtherTwo == null ? null : adminOtherTwo.trim();
    }

    public String getAdminOtherThree() {
        return adminOtherThree;
    }

    public void setAdminOtherThree(String adminOtherThree) {
        this.adminOtherThree = adminOtherThree == null ? null : adminOtherThree.trim();
    }

    public String getAdminOtherFour() {
        return adminOtherFour;
    }

    public void setAdminOtherFour(String adminOtherFour) {
        this.adminOtherFour = adminOtherFour == null ? null : adminOtherFour.trim();
    }

    public String getAdminOtherFive() {
        return adminOtherFive;
    }

    public void setAdminOtherFive(String adminOtherFive) {
        this.adminOtherFive = adminOtherFive == null ? null : adminOtherFive.trim();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId='" + adminId + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", isOpenActive=" + isOpenActive +
                ", adminPicture='" + adminPicture + '\'' +
                ", adminOtherOne='" + adminOtherOne + '\'' +
                ", adminOtherTwo='" + adminOtherTwo + '\'' +
                ", adminOtherThree='" + adminOtherThree + '\'' +
                ", adminOtherFour='" + adminOtherFour + '\'' +
                ", adminOtherFive='" + adminOtherFive + '\'' +
                '}';
    }
}