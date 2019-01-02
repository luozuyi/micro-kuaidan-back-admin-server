package com.kuaidan.entity;

import java.io.Serializable;

/**
 * 市
 * @author W1665
 */
public class Citys implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键Id
     */
    private String id;
    /**
     * 市名
     */
    private String name;
    /**
     * 省id
     */
    private String provinceId;
    /**
     * 代码
     */
    private String code;

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

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId == null ? null : provinceId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}