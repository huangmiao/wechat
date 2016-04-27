package com.mhuang.wechat.common.utils;

public class ConfigUtil {
	/**
	 * 服务号相关信息
	 */
	 public final static String SIGN_TYPE = "MD5";//签名加密方式
	/**
	 * 微信支付接口地址
	 */
	public final static String PAYMENT_URL = "https://api.mch.weixin.qq.com/";
	public final static String PAYMENT_PATH = "pay/";
	//微信支付统一接口(POST)
	public final static String UNIFIED_ORDER_URL = PAYMENT_URL + PAYMENT_PATH + "unifiedorder";
	//微信退款接口(POST)
	public final static String REFUND_URL = PAYMENT_URL + "secapi/pay/refund";
	//订单查询接口(POST)
	public final static String CHECK_ORDER_URL = PAYMENT_URL + PAYMENT_PATH + "orderquery";
	//关闭订单接口(POST)
	public final static String CLOSE_ORDER_URL = PAYMENT_URL + PAYMENT_PATH + "closeorder";
	//退款查询接口(POST)
	public final static String CHECK_REFUND_URL = PAYMENT_URL + PAYMENT_PATH + "refundquery";
	//对账单接口(POST)
	public final static String DOWNLOAD_BILL_URL = PAYMENT_URL + PAYMENT_PATH + "downloadbill";
	//短链接转换接口(POST)
	public final static String SHORT_URL = PAYMENT_URL + "tools/shorturl";
	//接口调用上报接口(POST)
	public final static String REPORT_URL = PAYMENT_URL + "payitil/report";

	//企业付款
	public final static String TRANSFERS_URL = PAYMENT_URL + "mmpaymkttransfers/promotion/transfers";
}
