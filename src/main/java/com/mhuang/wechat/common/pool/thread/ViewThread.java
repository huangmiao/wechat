package com.mhuang.wechat.common.pool.thread;

import com.mhuang.wechat.service.WeChatService;

/**
 * 
 * @Description 页面统计
 * @author mHuang
 * @date 2015年6月15日 下午2:32:22 
 * @version V1.0.0
 */
public class ViewThread extends BaseThread{

	private String fileName;
	
	public ViewThread(String openId,String fileName, WeChatService weChatService) {
		super(openId, weChatService);
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		System.out.println("=======页面统计=======");
	}

}