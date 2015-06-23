package com.mhuang.wechat.common.pool.thread;

import com.mhuang.wechat.service.WeChatService;

/**
 * 
 * @Description 文本消息
 * @author mHuang
 * @date 2015年6月8日 上午11:38:35 
 * @version V1.0.0
 */
public class TextThread extends BaseThread{

//	private Log log = LogFactory.getLog(this.getClass());
	private String content;
	
	public TextThread(String openId,String content,WeChatService weChatService) {
		super(openId, weChatService);
		this.content = content;
	}

	@Override
	public void run() {
		weChatService.saveOpTextSend(openId, content);
//			log.error("保存用户文本消息异常",e);
	}
}