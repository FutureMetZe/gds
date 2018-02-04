package com.gds.entity;

import java.util.Date;

public class PostReview {
    private Integer reviewId;

    private Integer blogId;

    private String blogTitle;

    private String reviewUserName;

    private String reviewUesrImg;

    private Date reviewCreattime;

    private String reviewContent;

    private Integer status;

    private String standby001;  //文章类型

    private String standby002;  //作者帐号

    private String standby003;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getReviewUserName() {
        return reviewUserName;
    }

    public void setReviewUserName(String reviewUserName) {
        this.reviewUserName = reviewUserName == null ? null : reviewUserName.trim();
    }

    public String getReviewUesrImg() {
        return reviewUesrImg;
    }

    public void setReviewUesrImg(String reviewUesrImg) {
        this.reviewUesrImg = reviewUesrImg == null ? null : reviewUesrImg.trim();
    }

    public Date getReviewCreattime() {
        return reviewCreattime;
    }

    public void setReviewCreattime(Date reviewCreattime) {
        this.reviewCreattime = reviewCreattime;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent == null ? null : reviewContent.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "PostReview{" +
                "reviewId=" + reviewId +
                ", blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", reviewUserName='" + reviewUserName + '\'' +
                ", reviewUesrImg='" + reviewUesrImg + '\'' +
                ", reviewCreattime=" + reviewCreattime +
                ", reviewContent='" + reviewContent + '\'' +
                ", status=" + status +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                ", standby003='" + standby003 + '\'' +
                '}';
    }
}