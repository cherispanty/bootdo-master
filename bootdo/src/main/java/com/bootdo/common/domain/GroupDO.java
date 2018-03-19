package com.bootdo.common.domain;

/**
 * Created by Linchong on 2018/3/18.
 */
public class GroupDO {
    private Long id;
    private Long teacherId;
    private Long studentId;
    private Long msId;
    private String answerTime;  //答辩时间

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

    public Long getMsId() {
        return msId;
    }

    public void setMsId(Long msId) {
        this.msId = msId;
    }

    public String getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(String answerTime) {
        this.answerTime = answerTime;
    }

    @Override
    public String toString() {
        return "GroupDO{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", studentId=" + studentId +
                ", msId=" + msId +
                ", answerTime='" + answerTime + '\'' +
                '}';
    }
}
