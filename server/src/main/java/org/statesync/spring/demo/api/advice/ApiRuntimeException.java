package org.statesync.spring.demo.api.advice;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiRuntimeException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -1313171097666393530L;

	private Object[] args;
	private HttpStatus status;

	public ApiRuntimeException(final String messageCode, final HttpStatus status, final Object... args) {
		super(messageCode);
		this.args = args;
		this.status = status;
	}
}
