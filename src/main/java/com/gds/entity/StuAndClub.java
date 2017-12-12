package com.gds.entity;

public class StuAndClub {
    /*
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '学生id',
  `dict_club_id` int(10) DEFAULT NULL COMMENT '所属社团id',
     */
    private Integer id;
    private String stu_num;
    private Integer dict_club_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getDict_club_id() {
        return dict_club_id;
    }

    public void setDict_club_id(Integer dict_club_id) {
        this.dict_club_id = dict_club_id;
    }

    public String getStu_num() {
        return stu_num;
    }

    public void setStu_num(String stu_num) {
        this.stu_num = stu_num;
    }

    @Override
    public String toString() {
        return "StuAndClub{" +
                "id=" + id +
                ", stu_num='" + stu_num + '\'' +
                ", dict_club_id=" + dict_club_id +
                '}';
    }

}
