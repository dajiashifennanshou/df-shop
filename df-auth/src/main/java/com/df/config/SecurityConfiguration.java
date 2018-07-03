package com.df.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.df.entity.Member;
import com.df.feign.MemberFeign;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MemberFeign memberFeign;

	// 请配置这个，以保证在刷新Token时能成功刷新
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		// 配置密码加密方式 BCryptPasswordEncoder，添加用户加密的时候请也用这个加密
		// 加密机制讲一下
		auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		// #####################实际开发中在下面写从数据库获取数据###############################
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// 通过用户名获取用户信息
				Object data = memberFeign.getUserByUsername(username).getData();
				String jsonString = JSON.toJSONString(data);
				Member member = JSONObject.parseObject(jsonString, Member.class);
				if (member != null) {
					// 创建spring security安全用户和对应的权限
					User user = new User(username, member.getPassword(),
							AuthorityUtils.createAuthorityList("admin", "manager"));
					return user;
				} else {
					throw new UsernameNotFoundException("用户[" + username + "]不存在");
				}
			}
		};
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.requestMatchers().anyRequest().and().authorizeRequests().antMatchers("/oauth/**").permitAll();
		// @formatter:on
	}
}
