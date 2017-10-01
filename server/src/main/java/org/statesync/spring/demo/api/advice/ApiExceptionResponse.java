package org.statesync.spring.demo.api.advice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiExceptionResponse {

	@Data
	@AllArgsConstructor
	private class ExceptionResponseField {

		private final String error;
		private final String description;
	}

	private final int status;
	private final long timestamp;

	private final List<ExceptionResponseField> errors = new ArrayList<>();

	ApiExceptionResponse(final HttpStatus httpStatus, final BindingResult bindingResult,
			final MessageSource messageSource) {
		this.timestamp = Instant.now().toEpochMilli();
		this.status = httpStatus.value();

		for (final FieldError error : bindingResult.getFieldErrors()) {
			final String message = error.getDefaultMessage();
			this.errors.add(new ExceptionResponseField(message,
					messageSource.getMessage(message, null, LocaleContextHolder.getLocale())));
		}
		for (final ObjectError error : bindingResult.getGlobalErrors()) {
			final String message = error.getDefaultMessage();
			this.errors.add(new ExceptionResponseField(message,
					messageSource.getMessage(message, null, LocaleContextHolder.getLocale())));
		}
		this.errors.sort(Comparator.comparing(ExceptionResponseField::getError));
	}

	ApiExceptionResponse(final HttpStatus httpStatus, final String field, final String description) {
		this.timestamp = Instant.now().toEpochMilli();
		this.status = httpStatus.value();

		this.errors.add(new ExceptionResponseField(field, description));
	}
}
