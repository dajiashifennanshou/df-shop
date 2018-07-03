package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author df
 * @version 创建时间：2018年6月28日 下午5:17:14
 * @Description 注册中心eureka启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApp {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApp.class, args);
	}
}
