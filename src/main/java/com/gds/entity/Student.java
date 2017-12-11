package com.gds.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
      `user_id` int(11) NOT NULL AUTO_INCREMENT,
      `stu_num` int(11) DEFAULT NULL COMMENT '学号',
      `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
      `rank` int(1) NOT NULL DEFAULT '0' COMMENT '管理员级别',
      `is_admin` int(1) NOT NULL DEFAULT '0' COMMENT '是否管理员',
      `is_disabled` int(1) NOT NULL DEFAULT '0' COMMENT '是否禁用',
     */
    private Integer user_id;
    private String stu_num;
    private Integer login_count;
    private Integer rank;
    private Integer is_admin;
    private Integer is_disabled;
    /*
      `username` varchar(50) NOT NULL COMMENT '用户名',
      `password` varchar(50) NOT NULL, 密码
      `stu_name` varchar(50) DEFAULT NULL COMMENT '姓名',
      `mobile` varchar(32) DEFAULT NULL, 电话
      `wx_number` varchar(20) DEFAULT NULL COMMENT '微信',
      `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
     */
    private String username;
    private String password;
    private String stu_name;
    private String mobile;
    private String wx_number;
    private String email;

    /*
      `register_time` varchar(50) DEFAULT NULL COMMENT '注册时间',
      `register_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '注册IP',
      `last_login_time` varchar(50) DEFAULT NULL COMMENT '最后登录时间',
      `last_login_ip` varchar(50) DEFAULT '127.0.0.1' COMMENT '最后登录IP',
      `standby001` varchar(50) DEFAULT NULL COMMENT '备用字段001',
      `standby002` varchar(50) DEFAULT NULL COMMENT '备用字段002',
     */
    private String register_time;
    private String register_ip;
    private String last_login_time;
    private String last_login_ip;
    private String standby001;
    private String standby002;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    public Integer getLogin_count() {
        return login_count;
    }

    public void setLogin_count(Integer login_count) {
        this.login_count = login_count;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Integer is_admin) {
        this.is_admin = is_admin;
    }

    public Integer getIs_disabled() {
        return is_disabled;
    }

    public void setIs_disabled(Integer is_disabled) {
        this.is_disabled = is_disabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWx_number() {
        return wx_number;
    }

    public void setWx_number(String wx_number) {
        this.wx_number = wx_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegister_time() {
        return register_time;
    }

    public void setRegister_time(String register_time) {
        this.register_time = register_time;
    }

    public String getRegister_ip() {
        return register_ip;
    }

    public void setRegister_ip(String register_ip) {
        this.register_ip = register_ip;
    }

    public String getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(String last_login_time) {
        this.last_login_time = last_login_time;
    }

    public String getLast_login_ip() {
        return last_login_ip;
    }

    public void setLast_login_ip(String last_login_ip) {
        this.last_login_ip = last_login_ip;
    }

    public String getStandby001() {
        return standby001;
    }

    public void setStandby001(String standby001) {
        this.standby001 = standby001;
    }

    public String getStandby002() {
        return standby002;
    }

    public void setStandby002(String standby002) {
        this.standby002 = standby002;
    }

    @Override
    public String toString() {
        return "Student{" +
                "user_id=" + user_id +
                ", stu_num=" + stu_num +
                ", login_count=" + login_count +
                ", rank=" + rank +
                ", is_admin=" + is_admin +
                ", is_disabled=" + is_disabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", wx_number='" + wx_number + '\'' +
                ", email='" + email + '\'' +
                ", register_time='" + register_time + '\'' +
                ", register_ip='" + register_ip + '\'' +
                ", last_login_time='" + last_login_time + '\'' +
                ", last_login_ip='" + last_login_ip + '\'' +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                '}';
    }
}
