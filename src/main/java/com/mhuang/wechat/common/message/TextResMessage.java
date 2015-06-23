package com.mhuang.wechat.common.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.mhuang.wechat.common.message.child.Content;


/**
 * 
 * @Description 文本响应消息
 * @author mHuang
 * @date 2015年6月4日 下午4:41:51 
 * @version V1.0.0
 */
public class TextResMessage extends BaseMessage{

	private static final long serialVersionUID = 1L;
	
	private static final String TEXT = "text";
	
	@JSONField(serialize = false)
	private String content;

	@JSONField(name = TEXT)
	private Content contentes;
	
	public Content getContentes() {
		return contentes;
	}


	public void setContentes(Content contentes) {
		this.contentes = contentes;
	}


	public TextResMessage(){
		setMsgType(TEXT);
	}
	
	
	public TextResMessage(String toUserName,String fromUserName){
		super(toUserName,fromUserName);
		setMsgType(TEXT);
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	//////////////////////////////////json///////////////////////////////
	public TextResMessage(String toUser){
		super(toUser);
	}
	
	public void saveJSON(String toUser,String content){
		setToUserName(toUser);
		if(contentes == null)
			contentes = new Content(); 
		contentes.setContent(content);
	}
}
