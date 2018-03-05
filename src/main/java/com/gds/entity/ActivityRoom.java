package com.gds.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityRoom implements Serializable {
    private Integer roomId;

    private String roomName;

    private String roomAddr;

    private String roomIsuse;

    private String roomUseName;

    private Date roomBeginTime;

    private Date roomOverTime;

    private String roomIntroduce;

    private String plan01;

    private String plan02;

    private String plan03;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getRoomAddr() {
        return roomAddr;
    }

    public void setRoomAddr(String roomAddr) {
        this.roomAddr = roomAddr == null ? null : roomAddr.trim();
    }

    public String getRoomIsuse() {
        return roomIsuse;
    }

    public void setRoomIsuse(String roomIsuse) {
        this.roomIsuse = roomIsuse == null ? null : roomIsuse.trim();
    }

    public String getRoomUseName() {
        return roomUseName;
    }

    public void setRoomUseName(String roomUseName) {
        this.roomUseName = roomUseName == null ? null : roomUseName.trim();
    }

    public String getRoomBeginTime() {
        if(roomBeginTime==null){
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomBeginTime);
    }

    public void setRoomBeginTime(Date roomBeginTime) {
        this.roomBeginTime = roomBeginTime;
    }

    public String getRoomOverTime() {
        if(roomOverTime==null){
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(roomOverTime);
    }

    public void setRoomOverTime(Date roomOverTime) {
        this.roomOverTime = roomOverTime;
    }

    public String getRoomIntroduce() {
        return roomIntroduce;
    }

    public void setRoomIntroduce(String roomIntroduce) {
        this.roomIntroduce = roomIntroduce == null ? null : roomIntroduce.trim();
    }

    public String getPlan01() {
        return plan01;
    }

    public void setPlan01(String plan01) {
        this.plan01 = plan01 == null ? null : plan01.trim();
    }

    public String getPlan02() {
        return plan02;
    }

    public void setPlan02(String plan02) {
        this.plan02 = plan02 == null ? null : plan02.trim();
    }

    public String getPlan03() {
        return plan03;
    }

    public void setPlan03(String plan03) {
        this.plan03 = plan03 == null ? null : plan03.trim();
    }

    @Override
    public String toString() {
        return "ActivityRoom{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomAddr='" + roomAddr + '\'' +
                ", roomIsuse='" + roomIsuse + '\'' +
                ", roomUseName='" + roomUseName + '\'' +
                ", roomBeginTime=" + roomBeginTime +
                ", roomOverTime=" + roomOverTime +
                ", roomIntroduce='" + roomIntroduce + '\'' +
                ", plan01='" + plan01 + '\'' +
                ", plan02='" + plan02 + '\'' +
                ", plan03='" + plan03 + '\'' +
                '}';
    }
}