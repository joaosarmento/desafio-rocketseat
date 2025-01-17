package com.java02.desafio_rocketseat_java_02.application.service.serviceImp;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseRequestDto;
import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.exception.CourseNotFoundException;
import com.java02.desafio_rocketseat_java_02.application.service.mappers.CourseMapper;
import com.java02.desafio_rocketseat_java_02.domain.model.Course;
import com.java02.desafio_rocketseat_java_02.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    public List<CourseResponseDto> getCourses() {
        final var listCourses = repository.findAll();
        return mapListResponseDto(listCourses);
    }

    public List<CourseResponseDto> getByCategoryAndName(String category, String name) {
        final var listCourses = repository.findByCategoryAndNameAndActive(category, name, true);
        return mapListResponseDto(listCourses);
    }

    public CourseResponseDto update(final Long id, final CourseRequestDto request) {
        final var courseFound = repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        courseFound.setName(request.getName());
        courseFound.setCategory(request.getCategory());
        courseFound.setActive(request.getActive());
        return mapper.map(repository.save(courseFound));
    }

    public List<CourseResponseDto> mapListResponseDto(List<Course> listCourses) {
        List<CourseResponseDto> listCoursesResponse = new ArrayList<>();
        for (Course course : listCourses) {
            listCoursesResponse.add(mapper.map(course));
        }
        return listCoursesResponse;
    }

    public CourseResponseDto create(final CourseRequestDto request) {
        var course = new Course();
        course.setName(request.getName());
        course.setCategory(request.getCategory());
        course.setActive(request.getActive());
        return mapper.map(repository.save(course));
    }
      
    public CourseResponseDto toggleActiveStatus(final Long id) {
        final var courseFound = repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        courseFound.setActive(!courseFound.getActive());
        return mapper.map(repository.save(courseFound));
    }
  
      public void deleteCourseById(final Long id) {
        repository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
        repository.deleteById(id);
    }
}
