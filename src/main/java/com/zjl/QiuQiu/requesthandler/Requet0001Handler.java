package com.zjl.QiuQiu.requesthandler;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zjl.QiuQiu.model.User;
import com.zjl.QiuQiu.response.Response;

@Controller
@RequestMapping("/Requet0001Handler")
public class Requet0001Handler extends RequestHandler {

	@Override
	public boolean hasRight(User iUser) {
		return false;
	}

	@Override
	public boolean checkParams(Map<String, Serializable> params) {
		return false;
	}

	@Override
	public Response bizHandle(HttpServletRequest request)
			throws RuntimeException {
		HashMap<String,String> map = new HashMap<String,String>();
		String userAccount = request.getParameter("userAccount");
		String password = request.getParameter("password");
		String result = "";
		if (StringUtils.equals(userAccount, "秋秋") && StringUtils.equals(password, "123123110")) {
			result = "success";
			map.put("result", result);
			return Response.success(map);
		} else {
			result = "error";
			map.put("result", result);
			return Response.success(map);
		}
	}

}
