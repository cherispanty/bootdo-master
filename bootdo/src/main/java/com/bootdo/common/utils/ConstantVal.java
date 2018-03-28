package com.bootdo.common.utils;

/**
 * @author Linchong
 * @date 2018/3/26 17:14
 */
public interface ConstantVal {
    public Byte LINK_STATUS_CONN = 1;  //建立老师学生之间的连接                            -->已同意状态
    public Byte LINK_STATUS_APPLY = 0;   //申请建立老师学生之间的连接（断开老师学生之间的连接）  -->待查看状态
    public Byte LINK_STATUS_CANCEL = -2;    //取消申请（邀请）
    public Byte LINK_STATUS_REFUSE = -1;    //拒绝申请（邀请）
}
