package com.gaoxing.domain;

public class Customer {
    private Integer custId;

    private String custName;

    private String custProfession;

    private String custPhone;

    private String email;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustProfession() {
        return custProfession;
    }

    public void setCustProfession(String custProfession) {
        this.custProfession = custProfession == null ? null : custProfession.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custProfession='" + custProfession + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}