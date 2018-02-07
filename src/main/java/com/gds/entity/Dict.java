package com.gds.entity;

import java.io.Serializable;

public class Dict implements Serializable {
    private Integer dictId;

    private String keyId;

    private String key;

    private String value;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId == null ? null : keyId.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    @Override
    public String toString() {
        return "Dict{" +
                "dictId=" + dictId +
                ", keyId='" + keyId + '\'' +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}