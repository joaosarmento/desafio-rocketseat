package com.java02.desafio_rocketseat_java_02.application.service;

import static java.time.LocalDateTime.now;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.exception.CourseNotFoundException;
import com.java02.desafio_rocketseat_java_02.domain.model.Course;
import com.java02.desafio_rocketseat_java_02.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCourseService {

  private final CourseRepository courseRepository;

  public CourseResponseDto update(final long id, final CourseRequestDto request) {
    final var courseFound =
        courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));

    if (request.name() != null) {
      courseFound.setName(request.name());
    }

    if (request.category() != null) {
      courseFound.setCategory(request.category());
    }

    courseFound.setUpdatedAt(now());

    return this.toResponse(courseRepository.save(courseFound));
  }

  private CourseResponseDto toResponse(final Course course) {
    return new CourseResponseDto(
        course.getName(),
        course.getCategory(),
        course.isActive(),
        course.getCreatedAt(),
        course.getUpdatedAt());
  }
}
