package com.mhuang.wechat.common.service;

import java.util.Map;

import com.mhuang.wechat.common.message.TextResMessage;
import com.mhuang.wechat.common.pool.WechatExecutor;
import com.mhuang.wechat.common.utils.MessageUtils;

/**
 * 微信核心处理service
 * @author mHuang、
 *
 */
public class CoreService {

	private WechatExecutor wechatExecuteService;
	
	private static final String WECHAT_SUBSCRIBE = "0";
	private static final String WECHAT_UNSUBSCRIBE = "1";
	
	private static final String TEXT_MSG = "text";
	private static final String IMAGE_MSG = "image";
	private static final String VOICE_MSG = "voice";
	private static final String VIDEO_MSG = "video";
	private static final String SHORT_VIDEO_MSG = "shiroVideo";
	private static final String LOCATION_MSG = "location";
	private static final String LINK_MSG = "link";
	
	/**
	 * 微信事件监听统一管理方法
	 * @return
	 */
	public StringBuffer manager(Map<String,String> wechatParamsMap,StringBuffer respContent) throws Exception{
		String msgType = wechatParamsMap.get("MsgType");
		switch(msgType){
			case "event": //事件推送
				event(wechatParamsMap,respContent);
				break;
			default: //非事件
				other(wechatParamsMap,respContent);
				break;
		}
		return respContent;
	}
	private void event(Map<String, String> map,StringBuffer respContent){
		String openId = map.get("FromUserName"),
			eventType = map.get("Event"),
			appId = map.get("ToUserName"),
			eventKey  = map.get("EventKey");
		switch (eventType) {
			case "subscribe"://订阅
				wechatExecuteService.subscribe(openId,WECHAT_SUBSCRIBE);
				break;
			case "unsubscribe"://取消订阅
				wechatExecuteService.subscribe(openId,WECHAT_UNSUBSCRIBE);
				break;
			case "CLICK"://点击菜单拉取消息时的事件推送
				break;
			case "VIEW"://用户点击view页面
				break;
		}
	}
	
	private void other(Map<String, String> map,StringBuffer respContent){
		String msgType = map.get("MsgType"),
			appId = map.get("ToUserName"),
			openId = map.get("FromUserName");
		switch(msgType){
			case TEXT_MSG:
				MessageUtils<TextResMessage> textMessageUtils = new MessageUtils<TextResMessage>();
				TextResMessage textMessage = new TextResMessage(openId,appId);
				textMessage.setContent("你发送了文本消息");
				respContent.append(textMessageUtils.fromObjectToXml(textMessage));
				String content = map.get("Content");
				wechatExecuteService.textMsg(openId, content);
				break;
			case IMAGE_MSG:
			case VOICE_MSG:
			case VIDEO_MSG:
			case SHORT_VIDEO_MSG:
			case LOCATION_MSG:
			case LINK_MSG:
		}
	}
	/**
	 * 
	 * @Description 接收消息
	 * @author mHuang
	 * @return
	 */
	private String recMessage(){
		return "";
	}
	
	private String subscribe(Map<String, String> map){
		return "";
	}
	//////////////////////////////setting getting///////////////////////////////////////////
	public void setWechatExecuteService(WechatExecutor wechatExecuteService) {
		this.wechatExecuteService = wechatExecuteService;
	}
}
