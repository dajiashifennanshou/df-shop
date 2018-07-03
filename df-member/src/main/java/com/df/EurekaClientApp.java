package com.df;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author df
 * @version 创建时间：2018年6月28日 下午5:28:24
 * @Description 类描述
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApp {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp.class, args);
	}
}
