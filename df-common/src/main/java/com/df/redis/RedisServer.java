package com.df.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisServer {

	@Autowired
	private StringRedisTemplate redis;

	public String setString(String key, String value) {
		redis.opsForValue().set(key, value);
		return "success";
	}

	public String setString(String key, String value, Integer secounds) {
		redis.opsForValue().set(key, value, secounds, TimeUnit.SECONDS);
		return "success";
	}

	public String getString(String key) {
		return redis.opsForValue().get(key);
	}

	public void delString(String key) {
		redis.delete(key);
	}
}
