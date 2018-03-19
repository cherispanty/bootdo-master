package com.bootdo.common.domain;

import java.time.LocalDateTime;

/**
 * Created by Linchong on 2018/3/18.
 */
public class TeacherStudentDO {
    private Long id;
    private Long teacherId;
    private Long studentId;
    //绑定情况（0：未绑定，1：绑定）
    private byte linkStatus;
    //论文题目
    private String paperTitle;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    //申请留言
    private String leaveMessage;

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public byte getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(byte linkStatus) {
        this.linkStatus = linkStatus;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
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


    @Override
    public String toString() {
        return "TeacherStudentDO{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", studentId=" + studentId +
                ", linkStatus=" + linkStatus +
                ", paperTitle='" + paperTitle + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", leaveMessage='" + leaveMessage + '\'' +
                '}';
    }
}
