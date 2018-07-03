package com.df.mq;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	@Autowired
	private JmsMessagingTemplate jmsTemplate;

	public void send(String queue_name, String json) {
		Destination destination = new ActiveMQQueue(queue_name);
		jmsTemplate.convertAndSend(destination, json);
	}
}
