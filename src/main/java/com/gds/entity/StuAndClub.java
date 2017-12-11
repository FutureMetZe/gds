package com.gds.entity;

public class StuAndClub {
    /*
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '学生id',
  `dict_club_id` int(10) DEFAULT NULL COMMENT '所属社团id',
     */
    private Integer id;
    private Integer user_id;
    private Integer dict_club_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getDict_club_id() {
        return dict_club_id;
    }

    public void setDict_club_id(Integer dict_club_id) {
        this.dict_club_id = dict_club_id;
    }

    @Override
    public String toString() {
        return "StuAndClub{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", dict_club_id=" + dict_club_id +
                '}';
    }
}
