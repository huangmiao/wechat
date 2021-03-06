package com.mhuang.wechat.common.template;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Template implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String touser;//发送的openid
    
    private String template_id = "";//模板id
    
    private String url;//跳转的url
    
    private Map<String,Map<String,String>> data = new HashMap<>();

    private final static String DEFAULT_COLOR = "#173177";
    private final static String FIRST = "first";
    private final static String KEYWORD = "keyword";
    private final static String VALUE = "value";
    private final static String COLOR = "color";
    private final static String REMARK = "remark";
    
    public void addKeyword(Integer index,String value){
        addKeyword(index,value,DEFAULT_COLOR);
    }   
    
    public void addKeyword(Integer index,String value,String color){
        addDataMap(KEYWORD + index, value, color);
    }
    
    public void addRemark(String value){
        addRemark(value,DEFAULT_COLOR);
    }   
    
    public void addRemark(String value,String color){
        addDataMap(REMARK, value, color);
    }
    
    public void addFirst(String value){
        addFirst(value,DEFAULT_COLOR);
    }
    public void addFirst(String value,String color){
        addDataMap(FIRST, value, color);
    }
    
    private void addDataMap(String type,String value,String color){
        Map<String, String> map = new HashMap<>();
        map.put(VALUE, value);
        map.put(COLOR, color);
        data.put(type, map);
    }
    
    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Map<String,String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String,String>> data) {
        this.data = data;
    }
}
