package com.lin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
public class ApiResult {

	private ApiResultCode code;

	@JsonInclude(value = Include.NON_NULL)
	private Object responseBody;

	@JsonInclude(value = Include.NON_EMPTY)
	private String msg;

	@JsonInclude(value = Include.NON_NULL)
	private Integer count;

	@JsonInclude(value = Include.NON_NULL)
	private Integer pageCount;

	private ApiResult(ApiResultCode code, Object responseBody) {
		this.code = code;
		this.responseBody = responseBody;
	}

	public static ApiResult ok() {
		return new ApiResult(ApiResultCode.SUCCESS, null);
	}

	public static ApiResult ok(Object obj) {
		return new ApiResult(ApiResultCode.SUCCESS, obj);
	}

	public static ApiResult fail() {
		return new ApiResult(ApiResultCode.FAILURE, null);
	}

	public static ApiResult fail(Object obj) {
		return new ApiResult(ApiResultCode.FAILURE, obj);
	}

	public ApiResult msg(String msg) {
		this.msg = msg;
		return this;
	}

	public ApiResult count(Integer count) {
		this.count = count;
		return this;
	}

	public ApiResult pageCount(Integer pageCount) {
		this.pageCount = pageCount;
		return this;
	}

	public enum ApiResultCode {
		SUCCESS, FAILURE;
	}
}
