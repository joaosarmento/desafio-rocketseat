package com.java02.desafio_rocketseat_java_02.application.service.exception;

import static java.lang.String.format;

import lombok.Getter;

@Getter
public class CourseNotFoundException extends BusinessException {

  private static final String ERROR_CODE = "not_found";
  private static final String MESSAGE = "Course with id %s not found.";

  public CourseNotFoundException(final long id) {
    super(format(MESSAGE, id), ERROR_CODE);
  }
}
