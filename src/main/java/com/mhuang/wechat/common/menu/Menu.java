package com.mhuang.wechat.common.menu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

public class Menu  implements Serializable{

	private static final long serialVersionUID = 1L;

	@JSONField(name="button")
	private List<Button> button = new LinkedList<Button>();

	public void buttonAdd(String type,String name,String key){
		button.add(Button.add(type, name, key));
	}
	
	public Button buttonAddSub(String subName,String type,String name,String key){
		return Button.subButton(subName, type, name, key);
	}
	
	/////////////setter getter//////////////////
	public List<Button> getButton() {
		return button;
	}

	public void setButton(List<Button> button) {
		this.button = button;
	}
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		Button button = menu.buttonAddSub("subName", "click", "dianji", "1234");
//		button.addSubButton("view", "viewName", "viewKey");
//		button.addSubButton("view", "viewName", "viewKey");
		menu.getButton().add(button);
		System.out.println(JSON.toJSONString(menu));
	}
}
