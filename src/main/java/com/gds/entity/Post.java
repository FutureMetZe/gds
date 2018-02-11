package com.gds.entity;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {

    private Integer blogId;

    private String blogTitle;

    private String blogAuthor;

    private Date blogCreatTime;

    private String blogLevel;

    private String blogSort;

    private Integer view;

    private Integer status;

    private String standby001;  //作者帐号

    private String standby002;  //相关类型社团

    private String standby003;  //主题

    private String blogContent;

    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor == null ? null : blogAuthor.trim();
    }

    public Date getBlogCreatTime() {
        return blogCreatTime;
    }

    public void setBlogCreatTime(Date blogCreatTime) {
        this.blogCreatTime = blogCreatTime;
    }

    public String getBlogLevel() {
        return blogLevel;
    }

    public void setBlogLevel(String blogLevel) {
        this.blogLevel = blogLevel == null ? null : blogLevel.trim();
    }

    public String getBlogSort() {
        return blogSort;
    }

    public void setBlogSort(String blogSort) {
        this.blogSort = blogSort == null ? null : blogSort.trim();
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
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

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }

    @Override
    public String toString() {
        return "Post{" +
                "blogId=" + blogId +
                ", blogTitle='" + blogTitle + '\'' +
                ", blogAuthor='" + blogAuthor + '\'' +
                ", blogCreatTime=" + blogCreatTime +
                ", blogLevel='" + blogLevel + '\'' +
                ", blogSort='" + blogSort + '\'' +
                ", view=" + view +
                ", status=" + status +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                ", standby003='" + standby003 + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}