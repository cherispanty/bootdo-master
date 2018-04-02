package com.bootdo.common.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Linchong on 2018/3/18.
 */
public class PaperDO {
    private Long id;
    //论文名称
    private String name;
    //上传者编号
    private Long studentId;
    //上传路径
    private String url;
    //创建时间
    private LocalDateTime createTime;
    //指导老师编号
    private Long teacherId;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    @Override
    public String toString() {
        return "PaperDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId=" + studentId +
                ", url='" + url + '\'' +
                ", createTime=" + createTime +
                ", teacherId=" + teacherId +
                ", collection='" + collection + '\'' +
                ", influence='" + influence + '\'' +
                ", factor='" + factor + '\'' +
                ", reference_count=" + reference_count +
                ", score=" + score +
                ", reviewOpinion='" + reviewOpinion + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}
