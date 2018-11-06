package com.df.result;
/**
* @author df
* @version 创建时间：2018年6月28日 下午4:55:30
* @Description 返回数据解析
*/
public class Result {
	// 响应code
	private Integer code;
	// 消息内容
	private String msg;
	// 返回data
	private Object data;

	public Result() {
	}

	public Result(Integer code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
