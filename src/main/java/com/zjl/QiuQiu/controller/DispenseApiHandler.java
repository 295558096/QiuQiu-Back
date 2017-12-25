package com.zjl.QiuQiu.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zjl.QiuQiu.requesthandler.RequestHandler;
import com.zjl.QiuQiu.response.Response;

@Controller
@RequestMapping("/api")
public class DispenseApiHandler implements Serializable {

	/**
	 * Api分发器，将前台传来的请求分发到对应Handler
	 */
	@RequestMapping(value={"", "/"})
    @CrossOrigin(origins="*",maxAge=3600)
	@ResponseBody
	public Response ApiDispatcher (HttpServletRequest request) {
		String apiKey = request.getParameter("apiKey");
		if (StringUtils.isEmpty(apiKey)) {
			return Response.ERROR_UNKNOWN();
		} else {
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
			RequestHandler reqestHandler = null;
			try {
				reqestHandler = (RequestHandler)ctx.getBean("request" + apiKey + "Handler");
			} catch (BeansException e) {
				e.printStackTrace();
				return Response.ERROR_UNKNOWN_API_KEY();
			}
			return reqestHandler.bizHandle(request);
		}
	}
}
