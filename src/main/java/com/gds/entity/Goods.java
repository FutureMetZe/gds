package com.gds.entity;

import java.util.Date;

public class Goods {
    private Integer goodsId;

    private String goodsName;

    private Date goodsCreatetime;

    private Integer goodsState;

    private String goodsDepartment;

    private String standby001;

    private String standby002;

    private String standby003;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Date getGoodsCreatetime() {
        return goodsCreatetime;
    }

    public void setGoodsCreatetime(Date goodsCreatetime) {
        this.goodsCreatetime = goodsCreatetime;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public String getGoodsDepartment() {
        return goodsDepartment;
    }

    public void setGoodsDepartment(String goodsDepartment) {
        this.goodsDepartment = goodsDepartment == null ? null : goodsDepartment.trim();
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

    public String getStandby003() {
        return standby003;
    }

    public void setStandby003(String standby003) {
        this.standby003 = standby003 == null ? null : standby003.trim();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCreatetime=" + goodsCreatetime +
                ", goodsState=" + goodsState +
                ", goodsDepartment='" + goodsDepartment + '\'' +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                ", standby003='" + standby003 + '\'' +
                '}';
    }
}