package com.gds.entity;

import java.io.Serializable;
import java.util.Date;

public class MyFile implements Serializable {
    private Integer fileId;

    private String fileName;

    private String fileUrl;

    private String fileIntroduce;

    private String uploadUsername;

    private Date fileCreatTime;

    private String plan001;

    private String plan002;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getFileIntroduce() {
        return fileIntroduce;
    }

    public void setFileIntroduce(String fileIntroduce) {
        this.fileIntroduce = fileIntroduce == null ? null : fileIntroduce.trim();
    }

    public String getUploadUsername() {
        return uploadUsername;
    }

    public void setUploadUsername(String uploadUsername) {
        this.uploadUsername = uploadUsername == null ? null : uploadUsername.trim();
    }

    public Date getFileCreatTime() {
        return fileCreatTime;
    }

    public void setFileCreatTime(Date fileCreatTime) {
        this.fileCreatTime = fileCreatTime;
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

    @Override
    public String toString() {
        return "MyFile{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", fileIntroduce='" + fileIntroduce + '\'' +
                ", uploadUsername='" + uploadUsername + '\'' +
                ", fileCreatTime=" + fileCreatTime +
                ", plan001='" + plan001 + '\'' +
                ", plan002='" + plan002 + '\'' +
                '}';
    }
}