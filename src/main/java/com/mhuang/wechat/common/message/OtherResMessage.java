package com.mhuang.wechat.common.message;

import com.mhuang.wechat.common.message.child.BaseChildMessage;
import com.mhuang.wechat.common.message.child.BaseOtherMessage;
import com.mhuang.wechat.common.message.child.Music;

/**
 * 
 * @Description 其他响应消息
 * @author mHuang
 * @date 2015年6月4日 下午5:05:19 
 * @version V1.0.0
 */
public class OtherResMessage<T> extends BaseMessage{

	private static final long serialVersionUID = 1L;
	
	@Deprecated
	enum MsgType{ //暂定状态
		IMAGE("image"),VOICE("voice"),VIDEO("video");
		
		private final String value;
		
		public String getValue() {
			return value;
		}

		MsgType(String value){
			this.value = value;
		}
	}
	
	private static final String IMAGE = "image";
	private static final String VOICE = "voice";
	private static final String VIDEO = "video";
	private static final String MUSIC = "music";
	
	private T otherMessage;

	public T getOtherMessage() {
		return otherMessage;
	}

	public void setOtherMessage(T otherMessage) {
		this.otherMessage = otherMessage;
	}
	
	public OtherResMessage(){
		
	}
	
	public OtherResMessage(String toUserName,String fromUserName){
		super(toUserName,fromUserName);
	}
	/**
	 * 
	 * @Description 根据类型进行添加
	 * @author mHuang
	 * @param mediaId
	 * @param msgType
	 */
	@Deprecated
	public void saveType(String mediaId,String msgType){
		baseSave(mediaId, msgType);
	}
	/**
	 * 
	 * @Description  响应图片消息
	 * @author mHuang
	 * @param mediaId
	 */
	public void saveImage(String mediaId){ 
		baseSave(mediaId, IMAGE);
	}
	
	/**
	 * 
	 * @Description 响应语音消息
	 * @author mHuang
	 */
	public void saveVoice(String mediaId){
		baseSave(mediaId,VOICE);
	}
	
	/**
	 * 
	 * @Description 响应视频消息
	 * @author mHuang
	 * @param mediaId
	 */
	public void saveVideo(String mediaId,String title,String descption){
		baseSaveTitle(mediaId,title,descption, VIDEO);
	}
	
	/**
	 * 
	 * @Description 响应音乐消息
	 * @author mHuang
	 * @param title
	 * @param descption
	 * @param musicUrl
	 * @param hQMusicUrl
	 * @param thumbMediaId
	 * @param msgType
	 */
	public void saveMusic(String title,String descption,String musicUrl,String hQMusicUrl,String thumbMediaId){
		setMsgType(MUSIC);
		otherMessage = (T)Music.setMusicMessage(title, descption, musicUrl, hQMusicUrl, thumbMediaId);
	}
	
	private void baseSave(String mediaId,String msgType){
		setMsgType(msgType);
		otherMessage = (T)BaseOtherMessage.setMedia(mediaId);
	}
	
	private void baseSaveTitle(String mediaId,String title,String descption,String msgType){
		setMsgType(msgType);
		otherMessage = (T)BaseChildMessage.setChildMessage(mediaId, title, descption);
	}
}
