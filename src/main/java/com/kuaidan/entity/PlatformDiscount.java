package com.kuaidan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author W1665
 */
public class PlatformDiscount implements Serializable {

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
     * 服务周期规则id
     */
    private String serviceCycleConfigId;
    /**
     * 服务周期类型
     */
    private Integer cycleType;
    /**
     * 服务次数规则id
     */
    private String serviceNumConfigId;
    /**
     * 服务次数类型
     */
    private Integer numType;
    /**
     * 折扣率
     */
    private BigDecimal discountRate;

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

    public String getServiceCycleConfigId() {
        return serviceCycleConfigId;
    }

    public void setServiceCycleConfigId(String serviceCycleConfigId) {
        this.serviceCycleConfigId = serviceCycleConfigId == null ? null : serviceCycleConfigId.trim();
    }

    public String getServiceNumConfigId() {
        return serviceNumConfigId;
    }

    public void setServiceNumConfigId(String serviceNumConfigId) {
        this.serviceNumConfigId = serviceNumConfigId == null ? null : serviceNumConfigId.trim();
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public Integer getCycleType() {
        return cycleType;
    }

    public void setCycleType(Integer cycleType) {
        this.cycleType = cycleType;
    }

    public Integer getNumType() {
        return numType;
    }

    public void setNumType(Integer numType) {
        this.numType = numType;
    }
}