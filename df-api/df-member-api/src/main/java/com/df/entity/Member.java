package com.df.entity;

import java.util.Date;

import lombok.Data;



@Data
public class Member {
	private Integer id;

	private String username;
	private String password;

	private String email;

	private Date createtime;

	private String qqopenid;

	private String wxopenid;

	private Boolean vipflag;

	private Boolean deleteflag;
}