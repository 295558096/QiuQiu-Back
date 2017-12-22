package com.zjl.QiuQiu.requesthandler;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zjl.QiuQiu.response.Response;

@Controller
@RequestMapping("/api")
public class DispenseApiHandler implements Serializable {

	/**
	 * Api分发器，将前台传来的请求分发到对应Handler
	 */
	@RequestMapping("")
    @CrossOrigin(origins="*",maxAge=3600)
	public @ResponseBody Response ApiDispatcher (HttpServletRequest request) {
		String apiKey = request.getParameter("apiKey");
		apiKey = "0001";
		if (StringUtils.isEmpty(apiKey)) {
			return Response.ERROR_UNKNOWN();
		} else {
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
			RequestHandler reqestHandler = (RequestHandler)ctx.getBean("request" + apiKey + "Handler");
			return reqestHandler.bizHandle(request);
		}
	}
}
