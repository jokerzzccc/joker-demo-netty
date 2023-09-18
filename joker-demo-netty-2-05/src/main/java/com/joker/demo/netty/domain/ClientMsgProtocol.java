package com.joker.demo.netty.domain;

/**
 * <p>
 * 消息传输协议
 * </p>
 *
 * @author jokerzzccc
 * @since 2023/9/15
 */
public class ClientMsgProtocol {

    private int type;       //1请求个人信息，2发送聊天信息
    private String msgInfo; //消息

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

}
