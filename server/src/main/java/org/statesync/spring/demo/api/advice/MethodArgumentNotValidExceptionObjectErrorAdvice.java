package org.statesync.spring.demo.api.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = ObjectErrorFormat.class)
public class MethodArgumentNotValidExceptionObjectErrorAdvice {

    private final MessageSource messageSource;

    @Autowired
    public MethodArgumentNotValidExceptionObjectErrorAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionResponse> handleException(MethodArgumentNotValidException exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(
                new ApiExceptionResponse(HttpStatus.BAD_REQUEST, exception.getBindingResult(), messageSource),
                headers,
                HttpStatus.BAD_REQUEST
        );
    }
}
