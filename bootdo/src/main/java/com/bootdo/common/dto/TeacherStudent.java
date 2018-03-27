package com.bootdo.common.dto;

import java.time.LocalDateTime;

/**
 * @author Linchong
 * @date 2018/3/26 16:20
 */
public class TeacherStudent {
    private Long id;
    private Long teacherId;
    private String teacherName;
    private Long studentId;
    private Byte linkStatus;
    private String paperTitle;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String leaveMessage;
    private String deptName;    //部门名
    private String researchDirection;   //研究方向

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection;
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

    public Byte getLinkStatus() {
        return linkStatus;
    }

    public void setLinkStatus(Byte linkStatus) {
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

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    @Override
    public String toString() {
        return "TeacherStudent{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", studentId=" + studentId +
                ", linkStatus=" + linkStatus +
                ", paperTitle='" + paperTitle + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", leaveMessage='" + leaveMessage + '\'' +
                ", deptName='" + deptName + '\'' +
                ", researchDirection='" + researchDirection + '\'' +
                '}';
    }
}
