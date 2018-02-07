package com.gds.entity;

import java.io.Serializable;
import java.util.Date;

public class Activity implements Serializable {
    private Integer activityId;

    private String activityTitle;

    private String activityType;

    private Date begintime;

    private Date overtime;

    private Integer peoplenum;

    private String forecastnum;

    //主办
    private String sponsor;

    private String site;

    private String activityIntroduce;

    private String plan001;

    private String plan002;

    private String plan003;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getOvertime() {
        return overtime;
    }

    public void setOvertime(Date overtime) {
        this.overtime = overtime;
    }

    public Integer getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(Integer peoplenum) {
        this.peoplenum = peoplenum;
    }

    public String getForecastnum() {
        return forecastnum;
    }

    public void setForecastnum(String forecastnum) {
        this.forecastnum = forecastnum == null ? null : forecastnum.trim();
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor == null ? null : sponsor.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getActivityIntroduce() {
        return activityIntroduce;
    }

    public void setActivityIntroduce(String activityIntroduce) {
        this.activityIntroduce = activityIntroduce == null ? null : activityIntroduce.trim();
    }

    public String getPlan001() {
        return plan001;
    }

    public void setPlan001(String plan001) {
        this.plan001 = plan001 == null ? null : plan001.trim();
    }

    public String getPlan002() {
        return plan002;
    }

    public void setPlan002(String plan002) {
        this.plan002 = plan002 == null ? null : plan002.trim();
    }

    public String getPlan003() {
        return plan003;
    }

    public void setPlan003(String plan003) {
        this.plan003 = plan003 == null ? null : plan003.trim();
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityType='" + activityType + '\'' +
                ", begintime=" + begintime +
                ", overtime=" + overtime +
                ", peoplenum=" + peoplenum +
                ", forecastnum='" + forecastnum + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", site='" + site + '\'' +
                ", activityIntroduce='" + activityIntroduce + '\'' +
                ", plan001='" + plan001 + '\'' +
                ", plan002='" + plan002 + '\'' +
                ", plan003='" + plan003 + '\'' +
                '}';
    }
}