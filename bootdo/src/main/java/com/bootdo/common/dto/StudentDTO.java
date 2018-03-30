package com.bootdo.common.dto;

/**
 * @author Linchong
 * @date 2018/3/28 20:29
 */
public class StudentDTO {
    private Long userId; //学号（sys-user:user_id）
    private String name; //真实姓名
    private Long deptId;    //班级编号
    private String className;   //班级名称
    private String username;    //昵称
    private String graduateYear;    //毕业年份
    private String email;
    private String mobile;
    private String paperTitle;  //学生的论文题目

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
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

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", deptId=" + deptId +
                ", className='" + className + '\'' +
                ", username='" + username + '\'' +
                ", graduateYear='" + graduateYear + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", paperTitle='" + paperTitle + '\'' +
                '}';
    }
}
