package com.kuaidan.entity;

import java.io.Serializable;
import java.util.Date;

public class TalkShowShare implements Serializable{
    /**
     *主键id
     */
    private String id;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *删除标志位 0:正常 1:删除 2:待删除
     */
    private String delFlag;
    /**
     *快蛋说id
     */
    private String talkShowId;
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

    public String getTalkShowId() {
        return talkShowId;
    }

    public void setTalkShowId(String talkShowId) {
        this.talkShowId = talkShowId == null ? null : talkShowId.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }
}