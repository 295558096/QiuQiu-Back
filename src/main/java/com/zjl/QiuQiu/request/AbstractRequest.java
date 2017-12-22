package com.zjl.QiuQiu.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.zjl.QiuQiu.request.AbstractRequest;

public abstract class AbstractRequest {
    /**
    *
    */
   private static final long serialVersionUID = 8834658708219270371L;

   private String appKey;

   //    private String AppSecret;
   private long timestamp;

   private String apiKey;

   private String sign;

   private String apiVersion;

   private Map<String, Serializable> params = new HashMap<String, Serializable>();

   public AbstractRequest(String appKey, String apiKey, long timestamp,
           String sign, String apiVersion) {
       this.appKey = appKey;
       this.apiKey = apiKey;
       this.timestamp = timestamp;
       this.sign = sign;
       this.apiVersion = apiVersion;
   }

   /**
    * @return the appKey
    */
   public String getAppKey() {
       return appKey;
   }

   /**
    * @param appKey the appKey to set
    */
   public void setAppKey(String appKey) {
       this.appKey = appKey;
   }

   /**
    * @return the apiKey
    */
   public String getApiKey() {
       return apiKey;
   }

   /**
    * @param apiKey the apiKey to set
    */
   public void setApiKey(String apiKey) {
       this.apiKey = apiKey;
   }

   /**
    * @return the params
    */
   public Map<String, Serializable> getParams() {
       Map<String, Serializable> tempParams = new HashMap<String, Serializable>(
               params.size());
       tempParams.putAll(params);
       return tempParams;
   }

   /**
    * @param params the params to set
    */
   public void setParams(Map<String, Serializable> params) {
       this.params.clear();
       if (params != null) {
           this.params.putAll(params);
       }
   }

   /**
    * @return the timestamp
    */
   public long getTimestamp() {
       return timestamp;
   }

   /**
    * @param timestamp the timestamp to set
    */
   public void setTimestamp(long timestamp) {
       this.timestamp = timestamp;
   }

   /**
    * @return the sign
    */
   public String getSign() {
       return sign;
   }

   /**
    * @param sign the sign to set
    */
   public void setSign(String sign) {
       this.sign = sign;
   }

   public void addParam(String name, Serializable value) {
       params.put(name, value);
   }

   public void removeParam(String name) {
       params.remove(name);
   }

   public Serializable getParam(String name) {
       return params.get(name);
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
       return JSON.toJSONString(this);
   }

   /**
    * @return the apiVersion
    */
   public String getApiVersion() {
       return apiVersion;
   }

   /**
    * @param version the apiVersion to set
    */
   public void setApiVersion(String version) {
       this.apiVersion = version;
   }

   /**
    * 从http请求中提取业务参数，交子类实现。子类可通过 {@link #addParam(String, Serializable)} 将抽取的参数添加到业务request对象
    * @param httpRequest http请求
    * @see #getSimpleStringParams(HttpServletRequest, String...)
    */
   protected abstract void getBizParams(HttpServletRequest httpRequest);

   /**
    * 从http请求中提取简单字符串参数，方便子类实现 {@link #getBizParams(HttpServletRequest)} 方法。
    * @param httpRequest http请求
    * @param paramNames 参数名列表
    */
   protected void getSimpleStringParams(HttpServletRequest httpRequest,
           String... paramNames) {
       if (paramNames == null) {
           return;
       }
       for (String paramName : paramNames) {
           String param = httpRequest.getParameter(paramName);
           addParam(paramName, param == null ? null : param.trim());
       }
   }

   /**
    * 验证签名合法性
    * @return 合法返回true，否则返回false
    */
   public boolean verifySign() {
	   return true;
   }
}
