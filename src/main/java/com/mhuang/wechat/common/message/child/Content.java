package com.mhuang.wechat.common.message.child;

import com.alibaba.fastjson.annotation.JSONField;

public class Content {

	@JSONField(name="content")
	String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Content(){
		
	}
}
