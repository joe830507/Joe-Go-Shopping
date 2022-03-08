package com.lin.enums;

public enum SuccessMsgEnum {

	SUCCESS("Success"), USER_INSERT("Sign up successfully!"), LOGIN("Sign in successfully!");

	SuccessMsgEnum(String msg) {
		this.msg = msg;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}
}
