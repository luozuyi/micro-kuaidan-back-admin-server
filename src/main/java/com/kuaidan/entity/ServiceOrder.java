package com.kuaidan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author W1665
 */
public class ServiceOrder implements Serializable {

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
     * 订单状态 0:待付款 1:服务中 2:服务完成 3:已取消
     */
    private String status;
    /**
     * 订单金额
     */
    private BigDecimal price;
    /**
     * 用户id
     */
    private String memberId;
    /**
     * 服务订单号
     */
    private String serviceOrderNumber;
    /**
     * 服务订单地址id
     */
    private String addressId;
    /**
     * 查询操作时间起始值
     */
    private String startCTime;

    /**
     * 查询操作时间终止值
     */
    private String endCTime;

    /**
     * 查询起始金额输入
     */
    private BigDecimal startNum;

    /**
     * 查询终止金额输入
     */
    private BigDecimal endNum;
    /**
     * 收货人手机号
     */
    private String memberTelephone;
    /**
     * 展示时间
     */
    private String showTime;

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getMemberTelephone() {
        return memberTelephone;
    }

    public void setMemberTelephone(String memberTelephone) {
        this.memberTelephone = memberTelephone;
    }

    public BigDecimal getStartNum() {
        return startNum;
    }

    public void setStartNum(BigDecimal startNum) {
        this.startNum = startNum;
    }

    public BigDecimal getEndNum() {
        return endNum;
    }

    public void setEndNum(BigDecimal endNum) {
        this.endNum = endNum;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber == null ? null : serviceOrderNumber.trim();
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }
}