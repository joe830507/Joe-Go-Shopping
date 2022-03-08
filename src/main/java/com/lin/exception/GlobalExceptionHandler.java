package com.lin.exception;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lin.dto.ApiResult;
import com.lin.enums.ErrorMessageEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = "com.lin.controller")
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { MethodArgumentNotValidException.class, BindException.class })
	public ApiResult handleMethodArgumentNotValidException(BindException e, HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		String[] errArray = new String[errors.size()];
		for (int i = 0; i < errors.size(); i++) {
			errArray[i] = errors.get(i).getDefaultMessage();
		}
		String messages = String.join(",", errArray);
		return ApiResult.fail().msg(messages);
	}

	@ExceptionHandler(value = BusinessException.class)
	public ApiResult handleBusinessException(BusinessException e, HttpServletResponse response) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		return ApiResult.fail().msg(e.getMessage());
	}

	@ExceptionHandler(value = Exception.class)
	public ApiResult handleUnknownException(Exception e, HttpServletResponse response) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		log.error("Unknown error happens...", e);
		String msg = ErrorMessageEnum.UNKNOWN.getMsg();
		return ApiResult.fail().msg(msg);
	}
}
