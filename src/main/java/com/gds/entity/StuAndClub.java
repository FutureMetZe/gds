package com.gds.entity;

import java.io.Serializable;

public class StuAndClub implements Serializable {
    private Integer id;

    private String stuNum;

    private Integer dictClubId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public Integer getDictClubId() {
        return dictClubId;
    }

    public void setDictClubId(Integer dictClubId) {
        this.dictClubId = dictClubId;
    }

    @Override
    public String toString() {
        return "StuAndClub{" +
                "id=" + id +
                ", stuNum='" + stuNum + '\'' +
                ", dictClubId=" + dictClubId +
                '}';
    }
}