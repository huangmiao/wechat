package com.mhuang.wechat.common.pool.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mhuang.wechat.service.ExecuteService;

/**
 * 
 * @Description 文本消息
 * @author mHuang
 * @date 2015年6月8日 上午11:38:35 
 * @version V1.0.0
 */
public class TextThread extends BaseThread{

	private String content;
	
	public TextThread(String openId,String content,ExecuteService weChatService) {
		super(openId, weChatService);
		this.content = content;
	}

	@Override
	public void run() {
		weChatService.saveOpTextSend(openId, content);
	}
}
