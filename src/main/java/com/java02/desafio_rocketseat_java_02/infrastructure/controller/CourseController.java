package com.java02.desafio_rocketseat_java_02.infrastructure.controller;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.serviceImp.CourseServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@Validated
@RequiredArgsConstructor
public class CourseController {

  private final CourseServiceImp courseServiceImp;

  @PutMapping("/{id}")
  public ResponseEntity<CourseResponseDto> update(
      @PathVariable("id") final long id, @RequestBody final CourseRequestDto request) {

    return ResponseEntity.ok(courseServiceImp.update(id, request));
  }
}
