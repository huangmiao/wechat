package com.mhuang.wechat.common.qrcode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Description 二维码
 * @author mHuang
 * @date 2015年6月10日 下午2:19:56 
 * @version V1.0.0
 */
public class QRCodeTicket implements Serializable{
	
	private enum QRCODE_TYPE{
		QR_LIMIT_SCENE,//临时二维码
		QR_LIMIT_STR_SCENE;//永久二维码
		public String toString() {
			return QR_LIMIT_STR_SCENE.name();
		};
	};
	
	private static final long serialVersionUID = 1L;

	private QRCODE_TYPE action_name;//二维码类型
	
	private String expire_seconds;//只有临时二维码有效。该二维码有效时间，以秒为单位。 最大不超过604800（即7天）。
	
	private Map<String, Scene> action_info = new HashMap<String, QRCodeTicket.Scene>();//二维码详细信息
	
	
	public QRCODE_TYPE getAction_name() {
		return action_name;
	}

	public void setAction_name(QRCODE_TYPE action_name) {
		this.action_name = action_name;
	}

	public String getExpire_seconds() {
		return expire_seconds;
	}

	public void setExpire_seconds(String expire_seconds) {
		this.expire_seconds = expire_seconds;
	}


	public Map<String, Scene> getAction_info() {
		return action_info;
	}


	public void setAction_info(Map<String, Scene> action_info) {
		this.action_info = action_info;
	}

	public void createTicket(String scene_str){
		setAction_name(QRCODE_TYPE.QR_LIMIT_STR_SCENE);
		Scene scene = new Scene();
		scene.setScene_str(scene_str);
		getAction_info().put("scene", scene);
	}

	class Scene{
		
		private String scene_id;//临时二维码采用
		
		private String scene_str;//永久二维码采用

		public String getScene_id() {
			return scene_id;
		}

		public void setScene_id(String scene_id) {
			this.scene_id = scene_id;
		}

		public String getScene_str() {
			return scene_str;
		}

		public void setScene_str(String scene_str) {
			this.scene_str = scene_str;
		}
	}

	public static void main(String[] args) {
		QRCodeTicket qrcode = new QRCodeTicket();
		qrcode.createTicket("11");
		System.out.println(JSON.toJSONString(qrcode));
	}
}
