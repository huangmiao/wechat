package com.mhuang.wechat.service;

public class WeChatService {

	public void share(String usrId, String status, String type,
			String shareName, String uuid) {
		System.out.println("====分享记录=====");
	}

	public void subscribe(String openId, String status) {
		System.out.println("====关注记录====");
	}

	public void saveOpTextSend(String openId, String content) {
		System.out.println("====保存文本消息记录====");
	}

}
