package com.mhuang.wechat.common.message.child;

/**
 * 
 * @Description 公共子消息类
 * @author mHuang
 * @date 2015年6月5日 上午10:56:22 
 * @version V1.0.0
 */
public class BaseChildMessage extends BaseOtherMessage{

	private String title;
	
	private String descption;

	public String getTitle() {
		return title; 
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescption() {
		return descption;
	}

	public void setDescption(String descption) {
		this.descption = descption;
	}

	public static BaseChildMessage setChildMessage(String mediaId,String title,String descption){
		BaseChildMessage baseChildMessage = new BaseChildMessage();
		baseChildMessage.setMediaId(mediaId);
		baseChildMessage.setTitle(title);
		baseChildMessage.setDescption(descption);
		return baseChildMessage;
	}
}
