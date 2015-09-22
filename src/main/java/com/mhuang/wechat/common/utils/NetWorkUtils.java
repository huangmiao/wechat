package com.mhuang.wechat.common.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 封装的HTTPClient请求
 * @author Administrator
 *
 */
public class NetWorkUtils {

	static final private int TIMEOUT = 30000;
	private int httpTimeOut = TIMEOUT;
	private static final String POST = "POST";
	private static final String GET = "GET";
	/**
	 * default is 30 sec
	 * set http timeout limit (million second)
	 * @param timeOut
	 */
	public void setHttpTimeOut(int timeOut) {
		this.httpTimeOut = timeOut;
	}
	
	/**
	 * (million second)
	 * @return http timeout limit
	 */
	public int getHttpTimeOut() {
		return this.httpTimeOut;
	}
	
	public JSONObject syncHttpClient(String webUrl){
		return syncHttpClient(webUrl,null);
	}
	
	public static void setRequest(HttpURLConnection connection,String methodType){
		try {
			connection.setRequestMethod(methodType);
			connection.setDoOutput(true);  
            connection.setDoInput(true);
            connection.setUseCaches(false); 
            // 连接超时
            connection.setConnectTimeout(TIMEOUT);

            // 读取超时 --服务器响应比较慢,增大时间
            connection.setReadTimeout(TIMEOUT);
            
            HttpURLConnection.setFollowRedirects(true);
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getString(String webUrl,CommonPostParamers params){
		HttpURLConnection urlConn = null;
		try {
			URL url = new URL(webUrl);
			urlConn = (HttpURLConnection) url.openConnection();;
	        setRequest(urlConn, "POST");
	        urlConn.setRequestProperty("connection", "keep-alive");
	        urlConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + params.boundaryString());
	        MultipartEntityBuilder reqEntity = params.getMultiPart();
	        reqEntity.build().writeTo(urlConn.getOutputStream());
	        return IOUtils.toString(urlConn.getInputStream());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (urlConn != null)
				urlConn.disconnect();
		}
		
		return null;
	}
	
	public JSONArray syncArrayHttpClient(String webUrl,CommonPostParamers params){
		return JSON.parseArray(getString(webUrl, params));
	}
	
	public JSONObject syncHttpClient(String webUrl,CommonPostParamers params){
		return JSON.parseObject(getString(webUrl,params));
	}
	
	private static Logger logger = LoggerFactory.getLogger(NetWorkUtils.class);
	
	public static String sync(String url) {
        return sync(url,"");
    }

	public static String sync(String url, byte[] PostData) {
		URL u = null;
		HttpURLConnection connection = null;
		//尝试发送请求
		try {
			u = new URL(url);
			connection = (HttpURLConnection) u.openConnection();
			setRequest(connection, POST);
			connection.setRequestProperty("Content-Type", "binary/octet-stream");
			OutputStream outStream = connection.getOutputStream();
			outStream.write(PostData);
			outStream.flush();
			outStream.close();
			
			int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
            	String result = IOUtils.toString(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            	logger.info("HTTP获取的数据是："+result);
            	return result;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return null;
	}
	
	public static String sync(String url,String data){
		logger.debug("请求的url："+url);
		HttpURLConnection connection = null;
        try {
            URL address_url = new URL(url);
            connection = (HttpURLConnection) address_url.openConnection();
            setRequest(connection, POST);
            //设置请求的属性
            connection.setRequestProperty("Content-type", "text/html");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("accept-language", "zh-CN");
            
            if(StringUtils.isNotBlank(data)){
            	 OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                 // 发送请求参数
                 out.write(data);
                 out.flush();
                 out.close();
            }
            
            
            //得到访问页面的返回值
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
            	String result = IOUtils.toString(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            	logger.info("HTTP获取的数据是："+result);
            	return result;
            }else{
            	logger.error("HTTP请求错误："+IOUtils.toString(connection.getErrorStream()));
            }
        } catch (MalformedURLException e) {
        	logger.error("mal：",e);
        } catch (IOException e) {
        	logger.error("io异常：",e);
        }catch(Exception e){
        	logger.error("未知异常，需要处理的",e);
        } finally {
            if(connection !=null){
                connection.disconnect();
            }
        }
        return null;
	}
	
	public static byte[] getImageBySync(String url){
		return getImageBySync(url, null);
	}
	
	public static byte[] getImageBySync(String url,String data) {
        HttpURLConnection connection = null;
        try {
            URL address_url = new URL(url);
            connection = (HttpURLConnection) address_url.openConnection();
            setRequest(connection, GET);
            //设置请求的属性
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("accept-language", "zh-CN");
            
            //设置访问超时时间及读取网页流的超市时间,毫秒值
            System.setProperty("sun.net.client.defaultConnectTimeout","30000");
            System.setProperty("sun.net.client.defaultReadTimeout", "30000");

            //设置参数
            if(StringUtils.isNotBlank(data)){
            	OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                // 发送请求参数
                out.write(data);
                out.flush();
                out.close();
            }
            
            //得到访问页面的返回值
            int response_code = connection.getResponseCode();
            if (response_code == HttpURLConnection.HTTP_OK) {
                return IOUtils.toByteArray(connection.getInputStream());
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
        return null;
    }
}
