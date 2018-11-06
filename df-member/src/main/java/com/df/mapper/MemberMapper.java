package com.df.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.df.entity.Member;



@Mapper
public interface MemberMapper{
	int deleteByPrimaryKey(Integer id);

	int insert(Member record);

	int insertSelective(Member record);

	Member selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Member record);

	int updateByPrimaryKey(Member record);

	Member getUserByUsername(@Param("username") String username);
}