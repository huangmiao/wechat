package com.mhuang.wechat.common.utils;

import java.io.UnsupportedEncodingException;

public class UnicodeUtils {

	/**
	 * 字符串转换unicode
	 */
	public static String string2Unicode(String string) {
		  try {
		      StringBuffer out = new StringBuffer("");
		      byte[] bytes = string.getBytes("unicode");
		      for (int i = 2; i < bytes.length - 1; i += 2) {
		        out.append("\\u");
		        String str = Integer.toHexString(bytes[i + 1] & 0xff);
		        for (int j = str.length(); j < 2; j++) {
		          out.append("0");
		        }
		        String str1 = Integer.toHexString(bytes[i] & 0xff);

		        out.append(str);
		        out.append(str1);
		        out.append("");
		      }
		      return out.toString().toUpperCase();
		    }catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		      return null;
		    }
	}
	
	/**
	 * unicode 转字符串
	 */
	public static String unicode2String(String unicode) {
		StringBuffer sb = new StringBuffer();
	    String str[] = unicode.toUpperCase().split("\\U");
	    for(int i=0;i<str.length;i++){
	      if(str[i].equals("")) continue;
	      char c = (char)Integer.parseInt(str[i].trim(),16);
	      sb.append(c);
	    }
	    return sb.toString();
	}
}
