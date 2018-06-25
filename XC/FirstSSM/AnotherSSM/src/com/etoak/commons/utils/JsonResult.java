package com.etoak.commons.utils;

/**
 *
 * @author Kerronex
 * @version 创建时间：2018年6月22日 下午3:51:09
 */
public class JsonResult {
	private Integer code;
	private String msg;

	
	public JsonResult() {
		super();
	}

	public JsonResult(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
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

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", msg=" + msg + "]";
	}

}
