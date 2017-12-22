package com.zjl.QiuQiu.response;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zjl.QiuQiu.response.Response;

public class Response implements Serializable {

	/**
    *
    */
   private static final long serialVersionUID = 1L;

   public static final Response SUCCESS()                  {return new Response("0000", "成功");}
   public static final Response ERROR_NEED_LOGIN()         {return new Response("0001", "请登录后访问");}
   public static final Response ERROR_INVALID_SIGN()       {return new Response("0002", "请求签名验证不通过");}
   public static final Response ERROR_EXPIRED()            {return new Response("0003", "请求已过期");}
   public static final Response ERROR_PERMISSIONS_DENIED() {return new Response("0004", "权限不足，您无权进行此操作");}
   public static final Response ERROR_INVALID_ARGS()       {return new Response("0005", "请求参数不合法");}
   public static final Response ERROR_FILE_NOT_FOUND()     {return new Response("0006", "文件或记录不存在");}
   public static final Response ERROR_CASE_NOT_FOUND()     {return new Response("0501", "请求的案件不存在");}
   public static final Response ERROR_UNKNOWN_API_KEY()    {return new Response("9998", "未知请求");}
   public static final Response ERROR_UNKNOWN()            {return new Response("9999", "未知系统错误");}

   private String code;
   private String msg;

   private Serializable data;

   public Response() {}

   public Response(String returnCode, String returnMsg) {
       this(returnCode, returnMsg, null);
   }

   public Response(String returnCode, String returnMsg, Serializable data) {
       this.code = returnCode;
       this.msg = returnMsg;
       this.data = data;
   }

   /**
    * @return the code
    */
   public String getCode() {
       return code;
   }
   /**
    * @param code the code to set
    */
   public void setCode(String code) {
       this.code = code;
   }
   /**
    * @return the msg
    */
   public String getMsg() {
       return msg;
   }
   /**
    * @param msg the msg to set
    */
   public void setMsg(String msg) {
       this.msg = msg;
   }
   /**
    * @return the data
    */
   public Serializable getData() {
       return data;
   }

   /**
    * @param data the data to set
    */
   public void setData(Serializable data) {
       this.data = data;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
       return toJsonString();
   }

   /**
    *
    */
   public String toJsonString() {
       return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);
   }

   public static final Response success(Serializable data) {
       Response r = SUCCESS();
       r.setData(data);
       return r;
   }
}
