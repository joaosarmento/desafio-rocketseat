package com.java02.desafio_rocketseat_java_02.application.service.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

  private final String errorCode;
  private final String message;

  public BusinessException(final String message, final String errorCode) {
    super(message);

    this.message = message;
    this.errorCode = errorCode;
  }
}
