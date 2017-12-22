package com.zjl.QiuQiu.requesthandler;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjl.QiuQiu.model.User;
import com.zjl.QiuQiu.request.AbstractRequest;
import com.zjl.QiuQiu.response.Response;

@Controller
@RequestMapping("/Requet0001Handler")
public class Requet0001Handler extends RequestHandler {
	
	@Override
	protected boolean hasRight(User iUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean checkParams(Map<String, Serializable> params) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Response bizHandle(HttpServletRequest request)
			throws RuntimeException {
		// TODO Auto-generated method stub
		return null;
	}
}
