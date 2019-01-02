package com.kuaidan.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author W1665
 */
public class PlatformServiceNumConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     *主键id
     */
    private String id;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *删除标志位 0:正常 1：删除 2：待删除
     */
    private String delFlag;
    /**
     * 服务类型 1个月 3个月 6个月
     */
    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}