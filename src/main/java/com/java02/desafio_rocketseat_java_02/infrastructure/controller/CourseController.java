package com.java02.desafio_rocketseat_java_02.infrastructure.controller;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.serviceImp.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
@Validated
@RequiredArgsConstructor
public class CourseController {

   private final CourseService service;

  @PutMapping("/{id}")
  public ResponseEntity<CourseResponseDto> updateCourse(
      @PathVariable("id") final long id, @RequestBody final CourseRequestDto request) {

    return ResponseEntity.ok(courseServiceImp.update(id, request));
  }

    @GetMapping("/courses")
    public List<CourseResponseDto> get() {
        return service.getCourses();
    }

    @GetMapping("/courses/search")
    public List<CourseResponseDto> getByCategoryAndName(
            @RequestParam(name = "category") String category,
            @RequestParam(name = "name") String name
    ) {
        return service.getByCategoryAndName(category, name);
    }
}
