package com.bootdo.common.dto;

/**
 * @author Linchong
 * @date 2018/3/19 10:03
 * @Description ‘选择老师’页面展示老师信息
 */
public class TeacherDTO {
    private String name;        //老师姓名
    private String deptName;    //部门名
    private String researchDirection;   //研究方向
    private Long totalNum;      //可带人数上限（不显示）
    private Long alreadyNum;    //已带学生（不显示）
    private Long readyNum;      //正在申请的人数
    private Long valueNum;      //剩余可带人数
    private Integer status;     //显示是否可带（0：可申请1：已满）
    private String mobile;      //手机号
    private String email;       //邮箱


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }

    public Long getAlreadyNum() {
        return alreadyNum;
    }

    public void setAlreadyNum(Long alreadyNum) {
        this.alreadyNum = alreadyNum;
    }

    public Long getReadyNum() {
        return readyNum;
    }

    public void setReadyNum(Long readyNum) {
        this.readyNum = readyNum;
    }

    public Long getValueNum() {
        return valueNum;
    }

    public void setValueNum(Long valueNum) {
        this.valueNum = valueNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "TeacherDTO{" +
                "name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", researchDirection='" + researchDirection + '\'' +
                ", totalNum=" + totalNum +
                ", alreadyNum=" + alreadyNum +
                ", readyNum=" + readyNum +
                ", valueNum=" + valueNum +
                ", status=" + status +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
