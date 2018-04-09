package com.bootdo.common.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Linchong
 * @date 2018/4/3 10:04
 */
public class PaperDTO {
    private Long id;
    //论文题目
    private String paperTitle;
    //论文文档名称
    private String name;
    //上传者编号
    private Long studentId;
    //学生姓名
    private String studentName;
    //学生班级
    private String className;
    //上传路径
    private String url;
    //创建时间
    private String createTime;
    //指导老师编号
    private Long teacherId;
    //老师姓名
    private String teacherName;
    //收录情况
    private String collection;
    //影响力
    private String influence;
    //影响因子
    private String factor;
    //引用次数
    private Long reference_count;
    //答辩分数
    private BigDecimal score;
    //评审意见
    private String reviewOpinion;
    //删除状态
    private Byte delFlag;
    //论文状态
    private Byte status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getInfluence() {
        return influence;
    }

    public void setInfluence(String influence) {
        this.influence = influence;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public Long getReference_count() {
        return reference_count;
    }

    public void setReference_count(Long reference_count) {
        this.reference_count = reference_count;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaperDTO{" +
                "id=" + id +
                ", paperTitle='" + paperTitle + '\'' +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", className='" + className + '\'' +
                ", url='" + url + '\'' +
                ", createTime='" + createTime + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", collection='" + collection + '\'' +
                ", influence='" + influence + '\'' +
                ", factor='" + factor + '\'' +
                ", reference_count=" + reference_count +
                ", score=" + score +
                ", reviewOpinion='" + reviewOpinion + '\'' +
                ", delFlag=" + delFlag +
                ", status=" + status +
                '}';
    }
}
