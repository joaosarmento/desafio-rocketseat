package com.java02.desafio_rocketseat_java_02.infrastructure.controller;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.java02.desafio_rocketseat_java_02.application.service.serviceImp.CourseService;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/course")
@Validated
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public CourseResponseDto updateCourse(
            @PathVariable("id") final Long id, @RequestBody final CourseRequestDto request) {

        return service.update(id, request);
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

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("id") Long id) {
        service.deleteCourseById(id);
        return ResponseEntity.ok().body("User successfully deleted.");
    }
}
