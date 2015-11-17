package com.mhuang.wechat.common.pool;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.mhuang.wechat.JDKExecute;
import com.mhuang.wechat.SpringExecute;
import com.mhuang.wechat.common.pool.thread.ShareThread;
import com.mhuang.wechat.common.pool.thread.SubscribeThread;
import com.mhuang.wechat.common.pool.thread.TextThread;
import com.mhuang.wechat.service.ExecuteService;

/**
 * 
 * @Description 微信处理类
 * @author mHuang
 * @date 2015年6月8日 上午10:45:51 
 * @version V1.0.0
 */
public class WechatExecutor {

	private ExecutorService executorService = Executors.newCachedThreadPool();

	public void subscribe(String openId,String status,ExecuteService weChatService){
		executorService.execute(new SubscribeThread(openId,status,weChatService));
	}
	
	public void textMsg(String openId,String content,ExecuteService weChatService){
		executorService.execute(new TextThread(openId, content, weChatService));
	}
	
	public void share(String usrId,String status,String type,String shareName,String uuid,ExecuteService weChatService){
		executorService.execute(new ShareThread(usrId, status, type, shareName, uuid, weChatService));
	}
	
	/**
	 * 其他方式调用线程池处理（异步） 
	 * @param clazz 需要调用的class（支持直接传class，采用jdk反射调用方式，传入beanName 代表使用spring代码方式）
	 * 		spring代理方式支持service（dao 自动引入）方式 。 JDK 需要自己做处理
	 * @param method
	 * 		调用的方法
	 */
	public void other(final Object clazz,final String method){
		executorService.execute(new Runnable() {
			public void run() {
				if(clazz instanceof Class<?>){
					try {
						JDKExecute.getMethodToValue((Class<?>)clazz, method);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}else{
					try {
						SpringExecute.getMethodToValue((String)clazz, method);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * 其他方式调用线程池处理（异步） 
	 * @param clazz 需要调用的class（支持直接传class，采用jdk反射调用方式，传入beanName 代表使用spring代码方式）
	 * 		spring代理方式支持service（dao 自动引入）方式 。 JDK 需要自己做处理
	 * @param method
	 * 		调用的方法
	 * @param param
	 * 		传输的值
	 */
	public void other(final Object clazz,final String method,final Object param){
		executorService.execute(new Runnable() {
			public void run() {
				if(clazz instanceof Class<?>){
					try {
						JDKExecute.getMethodToValue((Class<?>)clazz, method, param);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}else{
					try {
						SpringExecute.getMethodToValue((String)clazz, method, param);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * 其他方式调用线程池处理（异步） 
	 * @param clazz 需要调用的class（支持直接传class，采用jdk反射调用方式，传入beanName 代表使用spring代码方式）
	 * 		spring代理方式支持service（dao 自动引入）方式 。 JDK 需要自己做处理
	 * @param method
	 * 		调用的方法
	 * @param params 
	 * 		传输的值
	 */
	public void other(final Object clazz,final String method, final Object... params){
		executorService.execute(new Runnable() {
			public void run() {
				if(clazz instanceof Class<?>){
					try {
						JDKExecute.getMethodToValue((Class<?>)clazz, method,params);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}else{
					try {
						SpringExecute.getMethodToValue((String)clazz, method,params);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException | InstantiationException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
}
