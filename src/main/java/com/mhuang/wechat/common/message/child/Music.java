package com.mhuang.wechat.common.message.child;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 
 * @Description 响应音乐消息
 * @author mHuang
 * @date 2015年6月5日 下午1:53:05 
 * @version V1.0.0
 */
public class Music extends BaseChildMessage{

	@JSONField(name="musicurl")
	private String musicUrl;
	
	@JSONField(name="hqmusicurl")
	private String hQMusicUrl;
	
	@JSONField(name="thumb_media_id")
	private String thumbMediaId;

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	public static Music setMusicMessage(String title,String descption,String musicUrl,String hQMusicUrl,String thumbMediaId){
		Music music = new Music();
		music.setTitle(title);
		music.setDescption(descption);
		music.setMusicUrl(hQMusicUrl);
		music.sethQMusicUrl(hQMusicUrl);
		music.setThumbMediaId(thumbMediaId);
		return music;
	}
}
