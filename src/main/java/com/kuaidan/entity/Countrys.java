package com.kuaidan.entity;

import java.io.Serializable;

/**
 * 区
 * @author W1665
 */
public class Countrys implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键Id
     */
    private String id;
    /**
     * 区名
     */
    private String name;
    /**
     * 市id
     */
    private String cityId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }
}