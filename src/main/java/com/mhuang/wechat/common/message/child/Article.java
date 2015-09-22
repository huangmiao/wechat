package com.mhuang.wechat.common.message.child;

import com.alibaba.fastjson.annotation.JSONField;
import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * 
 * @Description 图文
 * @author mHuang
 * @date 2015年6月4日 下午5:03:47 
 * @version V1.0.0
 */
@XStreamAlias("item")
public class Article extends BaseChildMessage{
	 
	@JSONField(name="picurl") 
	private String picUrl;
	
	private String url;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public static Article getArticle(String title,String descption,String picUrl,String url){
		Article article = new Article();
		article.setTitle(title);
		article.setDescption(descption);
		article.setPicUrl(picUrl);
		article.setUrl(url);
		return article;
	}
}
