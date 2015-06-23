package com.mhuang.wechat.common.pool.thread;

import com.mhuang.wechat.service.WeChatService;

/**
 * 
 * @Description 
 * @author mHuang
 * @date 2015年6月8日 上午10:41:20 
 * @version V1.0.0
 */
public abstract class BaseThread implements Runnable{

	protected String openId;

	protected WeChatService weChatService;
	
	
	public abstract void run();
	
	public BaseThread(String openId,WeChatService weChatService){
		this.openId = openId;
		this.weChatService = weChatService;
	}
}
