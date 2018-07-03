package com.df.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.df.result.Result;

/**
 * @author df
 * @version 创建时间：2018年6月29日 下午3:38:01
 * @Description 用户服务层
 */

@RequestMapping("/member")
public interface MemberService {

	@RequestMapping("/register")
	public Result register(@RequestParam("email") String email, @RequestParam("password") String password);

	@RequestMapping("/getUserByUsername")
	public Result getUserByUsername(@RequestParam("username") String username);

	@RequestMapping("/testAuth")
	public Result testAuth(HttpServletRequest req);

}
