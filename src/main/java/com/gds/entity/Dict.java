package com.gds.entity;

public class Dict {
    /*
  `dict_id` int(4) NOT NULL AUTO_INCREMENT,
  `key_id` varchar(10) DEFAULT NULL,
  `key` varchar(100) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
     */
    private Integer dict_id;
    private String key_id;
    private String key;
    private String value;

    public Integer getDict_id() {
        return dict_id;
    }

    public void setDict_id(Integer dict_id) {
        this.dict_id = dict_id;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "dict_id=" + dict_id +
                ", key_id='" + key_id + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
