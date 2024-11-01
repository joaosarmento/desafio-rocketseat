package com.java02.desafio_rocketseat_java_02.infrastructure.controller;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.UpdateCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@Validated
@RequiredArgsConstructor
public class CourseController {

  private final UpdateCourseService courseServiceImp;

  @PutMapping("/{id}")
  public ResponseEntity<CourseResponseDto> updateCourse(
      @PathVariable("id") final long id, @RequestBody final CourseRequestDto request) {

    return ResponseEntity.ok(courseServiceImp.update(id, request));
  }
}
