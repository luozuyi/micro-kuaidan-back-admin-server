package com.kuaidan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 资金表
 * @author W1665
 */
public class Fund implements Serializable {

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
     * 金额
     */
    private BigDecimal money;
    /**
     * 类型 0:收入 1:支出
     */
    private String type;
    /**
     * 用户id
     */
    private String memberId;
    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 查询初试时间
     */
    private String startCTime;
    /**
     * 查询终止时间
     */
    private String endCTime;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 状态
     */
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartCTime() {
        return startCTime;
    }

    public void setStartCTime(String startCTime) {
        this.startCTime = startCTime;
    }

    public String getEndCTime() {
        return endCTime;
    }

    public void setEndCTime(String endCTime) {
        this.endCTime = endCTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }
}