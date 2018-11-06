package com.df.receive;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.df.adapter.MsgAdapter;
import com.df.adapter.impl.MailAdapter;
import com.df.adapter.impl.SmsAdapter;
import com.df.adapter.impl.WxAdapter;

/**
* @author df
* @version 创建时间：2018年6月29日 下午5:21:02
* @Description 监听消息队列
*/
@Component
public class MsgHandler {
	@Autowired
	private MailAdapter mailAdapter;
	@Autowired
	private WxAdapter wxAdapter;
	@Autowired
	private SmsAdapter smsAdapter;

	private MsgAdapter msgAdapter;

	// 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
	@JmsListener(destination = "df_queue")
	public void receiveQueue(String json) throws MessagingException {
		System.out.println("####消息服务收到的报文为:" + json);
		JSONObject oj = JSONObject.parseObject(json);
		String type = (String) oj.get("type");
		switch (type) {
		case "email":
			msgAdapter = mailAdapter;
			break;
		case "sms":
			msgAdapter = smsAdapter;
			break;
		case "wx":
			msgAdapter = wxAdapter;
			break;
		default:
			break;
		}
		msgAdapter.excute(json);
	}

}
