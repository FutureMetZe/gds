package com.gds.entity;

public class Club {
    /*
  `club_id` int(10) NOT NULL AUTO_INCREMENT,
  `club_name` varchar(255) DEFAULT NULL COMMENT '社团名称',
  `club_type` varchar(255) DEFAULT NULL COMMENT '社团类型',
  `club_faculty` varchar(255) DEFAULT NULL COMMENT '所属学院',
  `club_createtime` varchar(255) DEFAULT NULL COMMENT '成立时间',
  `club_status` int(1) DEFAULT '0',
  `club_introduce` varchar(9999) DEFAULT NULL COMMENT '社团简介',
  `club_standby001` varchar(255) DEFAULT NULL COMMENT '预留字段001',
  `club_standby002` varchar(255) DEFAULT NULL COMMENT '预留字段002',
  */
    private Integer club_id;
    private Integer club_status;
    private String club_name;
    private String club_type;
    private String club_faculty;
    private String club_createtime;
    private String club_introduce;
    private String club_standby001;
    private String club_standby002;

    public Integer getClub_id() {
        return club_id;
    }

    public void setClub_id(Integer club_id) {
        this.club_id = club_id;
    }

    public Integer getClub_status() {
        return club_status;
    }

    public void setClub_status(Integer club_status) {
        this.club_status = club_status;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getClub_type() {
        return club_type;
    }

    public void setClub_type(String club_type) {
        this.club_type = club_type;
    }

    public String getClub_faculty() {
        return club_faculty;
    }

    public void setClub_faculty(String club_faculty) {
        this.club_faculty = club_faculty;
    }

    public String getClub_createtime() {
        return club_createtime;
    }

    public void setClub_createtime(String club_createtime) {
        this.club_createtime = club_createtime;
    }

    public String getClub_introduce() {
        return club_introduce;
    }

    public void setClub_introduce(String club_introduce) {
        this.club_introduce = club_introduce;
    }

    public String getClub_standby001() {
        return club_standby001;
    }

    public void setClub_standby001(String club_standby001) {
        this.club_standby001 = club_standby001;
    }

    public String getClub_standby002() {
        return club_standby002;
    }

    public void setClub_standby002(String club_standby002) {
        this.club_standby002 = club_standby002;
    }

    @Override
    public String toString() {
        return "Club{" +
                "club_id=" + club_id +
                ", club_status=" + club_status +
                ", club_name='" + club_name + '\'' +
                ", club_type='" + club_type + '\'' +
                ", club_faculty='" + club_faculty + '\'' +
                ", club_createtime='" + club_createtime + '\'' +
                ", club_introduce='" + club_introduce + '\'' +
                ", club_standby001='" + club_standby001 + '\'' +
                ", club_standby002='" + club_standby002 + '\'' +
                '}';
    }

    public Club(Integer club_id, Integer club_status, String club_name, String club_type, String club_faculty, String club_createtime, String club_introduce, String club_standby001, String club_standby002) {
        this.club_id = club_id;
        this.club_status = club_status;
        this.club_name = club_name;
        this.club_type = club_type;
        this.club_faculty = club_faculty;
        this.club_createtime = club_createtime;
        this.club_introduce = club_introduce;
        this.club_standby001 = club_standby001;
        this.club_standby002 = club_standby002;
    }

    public Club() {
    }
}
