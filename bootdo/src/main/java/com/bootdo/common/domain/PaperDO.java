package com.bootdo.common.domain;

import java.math.BigDecimal;

/**
 * Created by Linchong on 2018/3/18.
 */
public class PaperDO {
    //文档编号（论文编号）
    private Long docId;
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


    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
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


    @Override
    public String toString() {
        return "PaperDO{" +
                "docId=" + docId +
                ", teacherId=" + teacherId +
                ", collection='" + collection + '\'' +
                ", influence='" + influence + '\'' +
                ", factor='" + factor + '\'' +
                ", reference_count=" + reference_count +
                ", score=" + score +
                ", reviewOpinion='" + reviewOpinion + '\'' +
                '}';
    }
}
