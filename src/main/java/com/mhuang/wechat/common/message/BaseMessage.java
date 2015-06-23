package com.mhuang.wechat.common.message;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Description 基础消息配置
 * @author mHuang
 * @date 2015年6月4日 下午4:44:27 
 * @version V1.0.0
 */
public abstract class BaseMessage implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@JSONField(name="touser")
	private String toUserName;
	
	@JSONField(serialize = false)
	private String fromUserName;
	
	@JSONField(serialize = false)
	private Long createTime;
	
	@JSONField(name = "msgtype")
	private String msgType = "";

	public BaseMessage(){
		
	}
	
	public BaseMessage(String tuser){
		setToUserName(tuser);
	}
	
	public BaseMessage(String toUserName,String fromUserName){
		setToUserName(toUserName);
		setFromUserName(fromUserName);
		setCreateTime(System.currentTimeMillis());
	}
	
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
