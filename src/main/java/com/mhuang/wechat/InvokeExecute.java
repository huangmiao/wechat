package com.mhuang.wechat;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 反射调用抽象
 * @author mHuang
 *
 */
public abstract class InvokeExecute {

	static Class<?> checkType(Object obj){
		if(obj instanceof Map){
			return Map.class;
		}else if(obj instanceof List){
			return List.class;
		}else if(obj instanceof Integer){
			return Integer.class;
		}else if(obj instanceof Long){
			return Long.class;
		}else if(obj instanceof Float){
			return Float.class;
		}else if(obj instanceof Double){
			return Double.class;
		}else if(obj instanceof Date){
			return Date.class;
		}else if(obj instanceof String){
			return String.class;
		}else if(obj instanceof Byte){
			return Byte.class;
		}else if(obj instanceof Boolean){
			return Boolean.class;
		}else{
			return Object.class;
		}
	}
}
