package com.df.adapter.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.df.adapter.MsgAdapter;

/**
* @author df
* @version 创建时间：2018年6月29日 下午5:15:12
* @Description 发送邮件的实现
*/
@Component
public class MailAdapter implements MsgAdapter{
	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String systemmail;

	@Override
	public boolean excute(String json) {
		try {
			JSONObject oj = JSONObject.parseObject(json);
			String to = (String) oj.get("to");
			String msg = "你好啊，" + to;
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
			helper.setFrom(systemmail);
			helper.setTo(to);
			helper.setSubject("注册通知！");
			helper.setText(msg, true);
			mailSender.send(mimeMessage);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
