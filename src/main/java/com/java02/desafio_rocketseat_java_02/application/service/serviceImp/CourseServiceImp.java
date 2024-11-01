package com.java02.desafio_rocketseat_java_02.application.service.serviceImp;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.exception.CourseNotFoundException;
import com.java02.desafio_rocketseat_java_02.application.service.mappers.CourseMapper;
import com.java02.desafio_rocketseat_java_02.infrastructure.repository.CourseRepository;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

// todo: tem que implementar a interface
@Component
@RequiredArgsConstructor
public class CourseServiceImp {
  // OBS: pra mim, essa pasta serviceImpl mudaria para nome usecase
  // e essa classe para Couse.
  // Talvez inclusive separando mesmo por caso de uso, no meu caso,
  // criaria um arquivo com o nome UpdateCourse com essa implementação
  // pra deixar mais organizado.

  private final CourseRepository courseRepository;
  private final CourseMapper mapper;

  public CourseResponseDto update(final long id, final CourseRequestDto request) {
    final var course =
        courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));

    if (request.name() != null) {
      course.setName(request.name());
    }

    if (request.category() != null) {
      course.setCategory(request.category());
    }

    course.setUpdatedAt(LocalDateTime.now());

    return mapper.map(course);
  }
}
