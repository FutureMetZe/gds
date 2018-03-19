package com.gds.entity;

import java.util.Date;

public class AssetsNotice {
    private Integer noticeId;

    private String noticeContent;

    private String noticeClubName;

    private Date noticeCreatTime;

    private Integer noticeState;

    private String standby001;

    private String standby002;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticeClubName() {
        return noticeClubName;
    }

    public void setNoticeClubName(String noticeClubName) {
        this.noticeClubName = noticeClubName == null ? null : noticeClubName.trim();
    }

    public Date getNoticeCreatTime() {
        return noticeCreatTime;
    }

    public void setNoticeCreatTime(Date noticeCreatTime) {
        this.noticeCreatTime = noticeCreatTime;
    }

    public Integer getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(Integer noticeState) {
        this.noticeState = noticeState;
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

    @Override
    public String toString() {
        return "AssetsNotice{" +
                "noticeId=" + noticeId +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeClubName='" + noticeClubName + '\'' +
                ", noticeCreatTime=" + noticeCreatTime +
                ", noticeState=" + noticeState +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                '}';
    }
}