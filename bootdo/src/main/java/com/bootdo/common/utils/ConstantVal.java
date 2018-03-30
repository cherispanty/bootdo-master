package com.bootdo.common.utils;

/**
 * @author Linchong
 * @date 2018/3/26 17:14
 */
public interface ConstantVal {
    public Byte LINK_STATUS_CONN = 1;  //建立老师学生之间的连接                            -->已同意状态
    public Byte LINK_STATUS_APPLY = 0;   //申请（邀请）建立老师学生之间的连接  -->待查看状态
    public Byte LINK_STATUS_CANCEL = -2;    //取消申请（邀请）
    public Byte LINK_STATUS_REFUSE = -1;    //拒绝申请（邀请）
    public Byte LINK_STATUS_UNBIND = -3;    //解除老师-学生的绑定关系（link_status: 1 -> -3）
    public Byte TEACHER_TYPE_INVITE = 1;    //老师邀请标记
    public Byte STUDENT_TYPE_APPLY = 0;    //学生申请标记
}
