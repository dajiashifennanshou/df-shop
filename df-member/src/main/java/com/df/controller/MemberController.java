package com.df.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.df.mq.MessageSender;
import com.df.result.Result;
import com.df.service.MemberService;
import com.df.utisl.AuthUtils;
import com.google.gson.JsonObject;

/**
 * @author df
 * @version 创建时间：2018年6月28日 下午5:32:55
 * @Description 类描述
 */
@RestController
public class MemberController implements MemberService{
	@Autowired
	MessageSender sender;
	
//	@Autowired
//	MemberMapper memberMapper;
	
	@Override
	public Result register(String emmail, String password) {
		System.out.println("emmail:"+emmail);
		System.out.println("password:"+password);
		JsonObject json = new JsonObject();
		json.addProperty("type", "mail");
		json.addProperty("adress", emmail);
		sender.send("df-queue", json.toString());
		return new Result(200,"注册成功",null);
	}
	@Override
	public Result getUserByUsername(String username) {
		return null;
//		Member member = memberMapper.getUserByUsername(username);
//		return new Result(200, "获取成功", member);
	}

	@Override
	public Result testAuth(HttpServletRequest req) {
		String reqUser = AuthUtils.getReqUser(req);
		JSONObject json = JSONObject.parseObject(reqUser);
		String id = (String) json.get("id");
		System.out.println("携带的用户信息 : " + reqUser);
		System.out.println("携带的用户信息 ID: " + id);
		return new Result(200, "这个是需要认证的请求", null);
	}

}
