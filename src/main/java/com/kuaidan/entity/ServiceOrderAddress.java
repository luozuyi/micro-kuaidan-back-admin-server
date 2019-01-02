package com.kuaidan.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author W1665
 */
public class ServiceOrderAddress implements Serializable {

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
     * 用户地址
     */
    private String memberAddress;

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

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress == null ? null : memberAddress.trim();
    }
}