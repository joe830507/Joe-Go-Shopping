package com.lin.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 8532176696505287197L;

	public BusinessException() {
		super();
	}

	public BusinessException(String msg) {
		super(msg);
	}
}
