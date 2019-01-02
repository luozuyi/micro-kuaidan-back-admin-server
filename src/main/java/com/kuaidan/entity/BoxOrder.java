package com.kuaidan.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author W1665
 */
public class BoxOrder implements Serializable {

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
     * 服务订单id
     */
    private String serviceOrderId;
    /**
     * 盒子状态 0:待发货 1:已发货 2:已收货
     */
    private String status;
    /**
     * 发货时间
     */
    private Date sendTime;
    /**
     * 盒子id
     */
    private String boxConfigId;
    /**
     * 盒子订单号
     */
    private String boxOrderNumber;
    /**
     * 快递单号
     */
    private String expressNumber;
    /**
     * 查询初试时间
     */
    private String startCTime;
    /**
     * 查询终止时间
     */
    private String endCTime;
    /**
     * 发货人
     */
    private String sendPerson;

    public String getSendPerson() {
        return sendPerson;
    }

    public void setSendPerson(String sendPerson) {
        this.sendPerson = sendPerson;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
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

    public String getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(String serviceOrderId) {
        this.serviceOrderId = serviceOrderId == null ? null : serviceOrderId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getBoxConfigId() {
        return boxConfigId;
    }

    public void setBoxConfigId(String boxConfigId) {
        this.boxConfigId = boxConfigId == null ? null : boxConfigId.trim();
    }

    public String getBoxOrderNumber() {
        return boxOrderNumber;
    }

    public void setBoxOrderNumber(String boxOrderNumber) {
        this.boxOrderNumber = boxOrderNumber == null ? null : boxOrderNumber.trim();
    }
}