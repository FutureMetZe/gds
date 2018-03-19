package com.gds.entity;

import java.util.Date;

public class StudentJoinClub {
    private Integer id;

    private String studentNum;

    private Integer wishClubId;

    private String isAgree;

    private Date applicationTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public Integer getWishClubId() {
        return wishClubId;
    }

    public void setWishClubId(Integer wishClubId) {
        this.wishClubId = wishClubId;
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree == null ? null : isAgree.trim();
    }

    public Date getApplicationTime() {

        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    @Override
    public String toString() {
        return "StudentJoinClub{" +
                "id=" + id +
                ", studentNum='" + studentNum + '\'' +
                ", wishClubId=" + wishClubId +
                ", isAgree='" + isAgree + '\'' +
                ", applicationTime=" + applicationTime +
                '}';
    }
}