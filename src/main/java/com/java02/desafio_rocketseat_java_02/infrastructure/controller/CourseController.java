package com.java02.desafio_rocketseat_java_02.infrastructure.controller;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.java02.desafio_rocketseat_java_02.application.service.serviceImp.CourseService;

import jakarta.websocket.server.PathParam;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
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
    @ResponseStatus(OK)
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

    @PostMapping
    public ResponseEntity<CourseResponseDto> create(@RequestBody final CourseRequestDto request) {

        return ResponseEntity.status(CREATED).body(service.create(request));
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathParam("id") Long id) {
        service.deleteCourseById(id);
        return ResponseEntity.ok().body("User successfully deleted.");
    }
}
