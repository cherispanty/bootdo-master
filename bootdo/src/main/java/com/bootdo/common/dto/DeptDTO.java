package com.bootdo.common.dto;

/**
 * 学生对应的班级，老师、管理员对应的部门或学院
 * @author Linchong
 * @date 2018/3/28 21:59
 */
public class DeptDTO {
    private Long deptId;
    private Long parentId;
    private String name;
    private Integer orderNum;
    private Byte delFlag;
    private Long leaderId;  //班级或学院负责人id

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    @Override
    public String toString() {
        return "DeptDTO{" +
                "deptId=" + deptId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", orderNum=" + orderNum +
                ", delFlag=" + delFlag +
                ", leaderId=" + leaderId +
                '}';
    }
}
