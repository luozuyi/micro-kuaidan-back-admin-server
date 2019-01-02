package com.kuaidan.entity;

import java.io.Serializable;
import java.util.Date;

public class TalkShow implements Serializable{
    /**
     * 主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * '删除标志位 0:正常 1:删除 2:待删除
     */
    private String delFlag;
    /**
     * 是否启用 0:启用 1:禁用
     */
    private String isStartUsing;
    /**
     * 标题
     */
    private String headline;
    /**
     * 内容
     */
    private String content;
    /**
     * 是否顶置 0:置顶 1:不置顶
     */
    private String isOverhead;
    /**
     * 支持数量
     */
    private Integer supportCount;
    /**
     *不支持数量
     */
    private Integer nonsupportCount;
    /**
     *收藏次数
     */
    private Integer collectCount;
    /**
     *分享次数
     */
    private Integer shareCount;
    /**
     *会员id
     */
    private String memberId;

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

    public String getIsStartUsing() {
        return isStartUsing;
    }

    public void setIsStartUsing(String isStartUsing) {
        this.isStartUsing = isStartUsing == null ? null : isStartUsing.trim();
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline == null ? null : headline.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIsOverhead() {
        return isOverhead;
    }

    public void setIsOverhead(String isOverhead) {
        this.isOverhead = isOverhead == null ? null : isOverhead.trim();
    }

    public Integer getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(Integer supportCount) {
        this.supportCount = supportCount;
    }

    public Integer getNonsupportCount() {
        return nonsupportCount;
    }

    public void setNonsupportCount(Integer nonsupportCount) {
        this.nonsupportCount = nonsupportCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }
}