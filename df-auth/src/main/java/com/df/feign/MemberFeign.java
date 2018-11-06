package com.df.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.df.service.MemberService;

/**
* @author df
* @version 创建时间：2018年7月2日 上午10:22:59
* @Description 类描述
*/
@FeignClient("member")
public interface MemberFeign extends MemberService{


}
