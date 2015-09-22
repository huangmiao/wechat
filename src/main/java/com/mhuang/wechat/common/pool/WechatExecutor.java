package com.mhuang.wechat.common.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mhuang.wechat.common.pool.thread.ShareThread;
import com.mhuang.wechat.common.pool.thread.SubscribeThread;
import com.mhuang.wechat.common.pool.thread.TextThread;
import com.mhuang.wechat.service.ExecuteService;

/**
 * 
 * @Description 微信处理类
 * @author mHuang
 * @date 2015年6月8日 上午10:45:51 
 * @version V1.0.0
 */
public class WechatExecutor {

	private ExecutorService executorService = Executors.newCachedThreadPool();

	
	public void subscribe(String openId,String status,ExecuteService weChatService){
		executorService.execute(new SubscribeThread(openId,status,weChatService));
	}
	
	public void textMsg(String openId,String content,ExecuteService weChatService){
		executorService.execute(new TextThread(openId, content, weChatService));
	}
	
	public void share(String usrId,String status,String type,String shareName,String uuid,ExecuteService weChatService){
		executorService.execute(new ShareThread(usrId, status, type, shareName, uuid, weChatService));
	}
}
