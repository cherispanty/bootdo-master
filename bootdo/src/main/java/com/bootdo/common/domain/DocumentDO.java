package com.bootdo.common.domain;

import java.time.LocalDateTime;

/**
 * Created by Linchong on 2018/3/18.
 */
public class DocumentDO {
    //文档编号
    private Long docId;
    //上传者id
    private Long userId;
    //文档名称
    private String name;
    //文档描述
    private String description;
    //存储路径
    private String path;
    //状态（0：正常，1：删除）
    private byte deleteStatus;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
    private LocalDateTime modifyTime;
    //阅读状态（0：未读，1：已读）
    private byte readStatus;
    //导师评论
    private String comment;
    //文档类型（0：周报，1：月报，2：论文）
    private byte docType;

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public byte getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public byte getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(byte readStatus) {
        this.readStatus = readStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public byte getDocType() {
        return docType;
    }

    public void setDocType(byte docType) {
        this.docType = docType;
    }

    @Override
    public String toString() {
        return "DocumentDO{" +
                "docId=" + docId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                ", deleteStatus=" + deleteStatus +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", readStatus=" + readStatus +
                ", comment='" + comment + '\'' +
                ", docType=" + docType +
                '}';
    }
}
