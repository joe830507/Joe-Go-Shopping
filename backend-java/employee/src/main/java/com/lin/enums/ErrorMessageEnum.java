package com.lin.enums;

public enum ErrorMessageEnum {

	UNKNOWN("Unknown error, please contact with the website manager."), PASSWORD_ERROR("wrong password");

	ErrorMessageEnum(String msg) {
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

}
