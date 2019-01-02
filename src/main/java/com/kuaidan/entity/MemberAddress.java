package com.kuaidan.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户地址实体类
 * @author W1665
 */
public class MemberAddress implements Serializable {

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
     * 用户Id
     */
    private String memberId;
    /**
     * 用户名称
     */
    private String memberName;
    /**
     * 用户电话
     */
    private String memberTelephone;
    /**
     * 用户详细地址
     */
    private String memberAddressDetail;
    /**
     * 是否默认
     */
    private String type;

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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getMemberTelephone() {
        return memberTelephone;
    }

    public void setMemberTelephone(String memberTelephone) {
        this.memberTelephone = memberTelephone == null ? null : memberTelephone.trim();
    }

    public String getMemberAddressDetail() {
        return memberAddressDetail;
    }

    public void setMemberAddressDetail(String memberAddressDetail) {
        this.memberAddressDetail = memberAddressDetail == null ? null : memberAddressDetail.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}