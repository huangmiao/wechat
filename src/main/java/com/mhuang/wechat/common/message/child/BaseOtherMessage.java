package com.mhuang.wechat.common.message.child;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Description 子消息公共类
 * @author mHuang
 * @date 2015年6月5日 上午10:55:55 
 * @version V1.0.0
 */
public class BaseOtherMessage {

	@JSONField(name = "media_id")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	public static BaseOtherMessage setMedia(String mediaId){
		BaseOtherMessage baseOtherMessage = new BaseOtherMessage();
		baseOtherMessage.setMediaId(mediaId);
		return baseOtherMessage;
	}
}
