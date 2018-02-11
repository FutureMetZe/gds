package com.gds.entity;

public class Student {
    private Integer userId;

    private String stuNum;

    private String stuName;

    private String password;

    private String username;

    private String email;

    private String registerTime;

    private String registerIp;

    private String lastLoginTime;

    private String lastLoginIp;

    private String wxNumber;

    private String mobile;

    private String standby001;

    private String standby002;

    private Integer loginCount;

    private Integer rank;

    private Integer isAdmin;

    private Integer isDisabled;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime == null ? null : registerTime.trim();
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp == null ? null : registerIp.trim();
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime == null ? null : lastLoginTime.trim();
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public String getWxNumber() {
        return wxNumber;
    }

    public void setWxNumber(String wxNumber) {
        this.wxNumber = wxNumber == null ? null : wxNumber.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStandby001() {
        return standby001;
    }

    public void setStandby001(String standby001) {
        this.standby001 = standby001 == null ? null : standby001.trim();
    }

    public String getStandby002() {
        return standby002;
    }

    public void setStandby002(String standby002) {
        this.standby002 = standby002 == null ? null : standby002.trim();
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Integer isDisabled) {
        this.isDisabled = isDisabled;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userId=" + userId +
                ", stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", registerIp='" + registerIp + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", wxNumber='" + wxNumber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                ", loginCount=" + loginCount +
                ", rank=" + rank +
                ", isAdmin=" + isAdmin +
                ", isDisabled=" + isDisabled +
                '}';
    }
}