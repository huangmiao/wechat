package com.mhuang.wechat.service;

/**
 * 执行接口..可自行拓展
 * @author mHuang
 *
 */
public interface ExecuteService {

	public void share(String usrId, String status, String type,
			String shareName, String uuid);
	public void subscribe(String openId, String status);
	public void subscribeOtherEvent(String openId,String status, String eventKey);
	public void saveOpTextSend(String openId, String content);
}
