package com.bootdo.common.dto;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Linchong
 * @date 2018/3/26 16:20
 */
public class TeacherStudent {
    private Long id;
    private Long teacherId;
    private String teacherName;
    private Long studentId;
    private String studentName;
    private String className;
    private Byte linkStatus;
    private String paperTitle;
    private Date createTime;
    private Date modifyTime;
    private String leaveMessage;
    private Byte type;          //标识是老师邀请还是学生申请
    private String deptName;    //部门名
    private String researchDirection;   //研究方向

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
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
                ", studentName='" + studentName + '\'' +
                ", className='" + className + '\'' +
                ", linkStatus=" + linkStatus +
                ", paperTitle='" + paperTitle + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", leaveMessage='" + leaveMessage + '\'' +
                ", type=" + type +
                ", deptName='" + deptName + '\'' +
                ", researchDirection='" + researchDirection + '\'' +
                '}';
    }
}
