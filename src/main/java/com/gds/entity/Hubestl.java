package com.gds.entity;

public class Hubestl {
    private Integer id;

    private String name;

    private String sex;

    private String faculty;

    private String mobile;

    private String stunum;

    private String department;

    private String createtime;

    private String position;

    private Integer isquit;

    private String standby001;

    private String standby002;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty == null ? null : faculty.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum == null ? null : stunum.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getIsquit() {
        return isquit;
    }

    public void setIsquit(Integer isquit) {
        this.isquit = isquit;
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
        return "Hubestl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", faculty='" + faculty + '\'' +
                ", mobile='" + mobile + '\'' +
                ", stunum='" + stunum + '\'' +
                ", department='" + department + '\'' +
                ", createtime='" + createtime + '\'' +
                ", position='" + position + '\'' +
                ", isquit=" + isquit +
                ", standby001='" + standby001 + '\'' +
                ", standby002='" + standby002 + '\'' +
                '}';
    }
}