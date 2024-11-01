package com.java02.desafio_rocketseat_java_02.infrastructure.handler;

import com.java02.desafio_rocketseat_java_02.application.service.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class CourseControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({BusinessException.class})
  public ResponseEntity<Object> handleBusinessException(final BusinessException ex) {
    log.error(ex.getMessage());
    final var errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode());

    return ResponseEntity.badRequest().body(errorResponse);
  }
}
