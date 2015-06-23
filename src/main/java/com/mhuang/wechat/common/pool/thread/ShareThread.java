package com.mhuang.wechat.common.pool.thread;

import sun.rmi.runtime.Log;

import com.mhuang.wechat.service.WeChatService;

/**
 * 
 * @Description 分享处理线程
 * @author mHuang
 * @date 2015年6月16日 上午11:58:37 
 * @version V1.0.0
 */
public class ShareThread extends BaseThread{

//	private Log log = LogFactory.getLog(this.getClass());
	
	private String usrId;
	private String status;
	private String type;
	private String shareName;
	private String uuid;
	
	public ShareThread(String usrId,String status,String type,String shareName,String uuid,WeChatService weChatService){
		super(usrId,weChatService);
		this.weChatService = weChatService;
		this.usrId = usrId;
		this.status = status;
		this.type = type;
		this.shareName = shareName;
		this.uuid = uuid;
	}

	@Override
	public void run() {
		try {
			synchronized (usrId) {
				weChatService.share(usrId, status,type, shareName, uuid);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
