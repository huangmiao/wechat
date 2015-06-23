package com.mhuang.wechat.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * 	TODO 敬请期待完善
 * @Description 
 * @author mHuang
 * @date 2015年6月23日 上午10:52:31 
 * @version V1.0.0
 */
public class HttpUtils {

	public static String getMsg(String url){
		return getMsg(url,null);
	}
	public static String getMsg(String url,String data){
		HttpURLConnection connection = null;
		try {
			URL addressUrl = new URL(url);
			connection = (HttpURLConnection) addressUrl.openConnection();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getHttpMsg(String url,String data,String type) {
        HttpURLConnection connection = null;
        String content = "";
        try {
            URL address_url = new URL(url);
            connection = (HttpURLConnection) address_url.openConnection();
            
            connection.setDoOutput(true);  
            connection.setDoInput(true);
            connection.setUseCaches(false); 
            connection.setRequestMethod(type); 
            
            //设置请求的属性
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("accept-language", "zh-CN");
            
            //设置访问超时时间及读取网页流的超市时间,毫秒值
            System.setProperty("sun.net.client.defaultConnectTimeout","30000");
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");

            //设置参数
            ObjectOutputStream outStream = (ObjectOutputStream)connection.getOutputStream();
            outStream.writeObject(data);
            
            //得到访问页面的返回值
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                InputStream in = connection.getInputStream();
                //修改update 文件名
                FileUtils.copyInputStreamToFile(in, new File("d:\\5201314.jpg"));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
        return "";
    }
}
