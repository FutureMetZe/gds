package com.gds.entity;

import java.io.Serializable;
import java.util.Date;

public class Banners implements Serializable {

    //图片尺寸为 820*200

    private Integer bannersId;

    private String bannersName;

    private String bannersImgUrl;

    private Date bannerCreatTime;

    private String bannerIntroduce;

    private String standby001;

    private String standby002;

    private String standby003;

    public Integer getBannersId() {
        return bannersId;
    }

    public void setBannersId(Integer bannersId) {
        this.bannersId = bannersId;
    }

    public String getBannersName() {
        return bannersName;
    }

    public void setBannersName(String bannersName) {
        this.bannersName = bannersName == null ? null : bannersName.trim();
    }

    public String getBannersImgUrl() {
        return bannersImgUrl;
    }

    public void setBannersImgUrl(String bannersImgUrl) {
        this.bannersImgUrl = bannersImgUrl == null ? null : bannersImgUrl.trim();
    }

    public Date getBannerCreatTime() {
        return bannerCreatTime;
    }

    public void setBannerCreatTime(Date bannerCreatTime) {
        this.bannerCreatTime = bannerCreatTime;
    }

    public String getBannerIntroduce() {
        return bannerIntroduce;
    }

    public void setBannerIntroduce(String bannerIntroduce) {
        this.bannerIntroduce = bannerIntroduce == null ? null : bannerIntroduce.trim();
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
        return "Banners{" +
                "bannersId=" + bannersId +
                ", bannersName='" + bannersName + '\'' +
                ", bannersImgUrl='" + bannersImgUrl + '\'' +
                ", bannerCreatTime=" + bannerCreatTime +
                ", bannerIntroduce='" + bannerIntroduce + '\'' +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                ", standby003='" + standby003 + '\'' +
                '}';
    }
}