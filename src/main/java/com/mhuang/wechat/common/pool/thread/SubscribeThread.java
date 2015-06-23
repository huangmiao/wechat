package com.mhuang.wechat.common.pool.thread;

import java.sql.SQLException;

import com.mhuang.wechat.service.WeChatService;

/**
 * 
 * @Description 关注监听
 * @author mHuang
 * @date 2015年6月8日 上午10:37:31 
 * @version V1.0.0
 */
public class SubscribeThread extends BaseThread{

	
	private String status; //0代表关注 1代表取消关注
	
	public SubscribeThread(String openId,String status,WeChatService weChatService) {
		super(openId,weChatService);
		this.status = status;
	}

	@Override
	public void run() {
		synchronized (openId) {//
			weChatService.subscribe(openId,status);
		}
	}
	
}
