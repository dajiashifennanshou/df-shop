package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
* @author df
* @version 创建时间：2018年7月2日 上午10:22:44
* @Description 类描述
*/
@SpringBootApplication
@EnableEurekaClient
public class AuthServerApp {
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApp.class, args);
	}
}
