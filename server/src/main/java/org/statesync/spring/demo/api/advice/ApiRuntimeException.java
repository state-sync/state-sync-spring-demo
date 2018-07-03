// Generated by delombok at Tue Jul 03 21:12:42 NOVT 2018
package org.statesync.spring.demo.api.advice;

import org.springframework.http.HttpStatus;

public class ApiRuntimeException extends RuntimeException {
	/**
	 */
	private static final long serialVersionUID = -1313171097666393530L;
	private Object[] args;
	private HttpStatus status;

	public ApiRuntimeException(final String messageCode, final HttpStatus status, final Object... args) {
		super(messageCode);
		this.args = args;
		this.status = status;
	}

	@java.lang.SuppressWarnings("all")
	public Object[] getArgs() {
		return this.args;
	}

	@java.lang.SuppressWarnings("all")
	public HttpStatus getStatus() {
		return this.status;
	}
}
