package com.mhuang.wechat.common.menu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 
 * @Description 一级button
 * @author mHuang
 * @date 2015年6月8日 下午2:26:28 
 * @version V1.0.0
 */
public class Button implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String URL_TYPE = "view";
	private static final String MEDIA_TYPE = "media_id";
	private static final String IMAGE_TYPE = "view_limited";
	
	private String name;
	
	private String type;
	
	private String key;
	
	private String url;
	
	private String media_id;
	
	@JSONField(name="sub_button")
	private List<Button> subButton = new LinkedList<Button>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Button> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<Button> subButton) {
		this.subButton = subButton;
	}
	
	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public Button(){
		
	}
	
	public static Button subButton(String subName,String type,String name,String key){
		Button button = new Button();
		button.setName(name);
		button.getSubButton().add(Button.add(type, subName, key));
		return button;
	}
	
	public void addSubButton(String type,String name,String key){
		getSubButton().add(Button.add(type, name, key));
	}
	
	public Button(String type,String name,String key){
		if(StringUtils.equals(URL_TYPE, type)){
			setUrl(key);
		}else if(StringUtils.equals(IMAGE_TYPE, type) || StringUtils.equals(MEDIA_TYPE, type)){
			setMedia_id(key);
		}else{
			setKey(key);
		}
		setType(type);
		setName(name);
	}
	
	public static Button add(String type,String name,String key){
		return new Button(type,name,key);
	}

}
