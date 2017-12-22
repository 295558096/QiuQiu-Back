package com.zjl.QiuQiu.requesthandler;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zjl.QiuQiu.model.User;
import com.zjl.QiuQiu.request.AbstractRequest;
import com.zjl.QiuQiu.response.Response;

public abstract class RequestHandler {
	/**
     * 日志，子类可访问
     */
    protected final static Logger log = LoggerFactory.getLogger(RequestHandler.class);

    /**
     * 多值分隔符
     */
    protected final static String MULTI_VALUE_SEPARATOR = ";";

    /**
     * 调用此接口是否需要登录。
     * <p>
     * <strong>注意：为了增强安全性，默认返回true，子类可根据需要重写此方法。</strong>
     * </p>
     * @return 需要登录返回true，否则返回false
     */
    protected boolean isLoginRequired() {
        return true;
    }
    /**
     * 给定用户是否有权限调用此接口，交由子类实现。
     * @param iUser 用户
     * @return 有权限返回true，否则返回false
     */
    protected abstract boolean hasRight(User iUser);
    /**
     * 检查业务参数是否合法，交由子类实现。
     * @param params 请求中携带的业务参数
     * @return 合法返回true，否则返回false
     */
    protected abstract boolean checkParams(Map<String, Serializable> params);
    /**
     * 业务处理，交由子类实现。
     * @param request 请求实体
     * @return 响应
     */
    protected abstract Response bizHandle(HttpServletRequest request) throws RuntimeException;

}
