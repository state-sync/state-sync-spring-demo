package org.statesync.spring.demo.api.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = ObjectErrorFormat.class)
public class RuntimeExceptionAdvice {

	private static final Logger log = LoggerFactory.getLogger(RuntimeExceptionAdvice.class);

	private final MessageSource messageSource;
	private final HttpHeaders headers;

	@Autowired
	public RuntimeExceptionAdvice(final MessageSource messageSource) {
		this.messageSource = messageSource;
		this.headers = new HttpHeaders();
		this.headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	}

	private String getMessage(final String key, final Object... args) {
		return this.messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiExceptionResponse> handleException(final RuntimeException exception) {

		final String key = exception.getMessage();
		String message;
		HttpStatus status = HttpStatus.BAD_REQUEST;

		if (key != null) {
			Object[] args = null;
			if (exception instanceof ApiRuntimeException) {
				final ApiRuntimeException apiException = (ApiRuntimeException) exception;
				args = apiException.getArgs();
				status = apiException.getStatus();
			}
			message = getMessage(key, args);
		} else {
			message = getMessage("error", exception.getClass().getSimpleName());
		}

		log.error(message, exception);

		return new ResponseEntity<>(new ApiExceptionResponse(status, key, message), this.headers, status);
	}
}
