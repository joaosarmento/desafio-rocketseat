package com.java02.desafio_rocketseat_java_02.application.service.serviceImp;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.application.service.mappers.CourseMapper;
import com.java02.desafio_rocketseat_java_02.domain.model.Course;
import com.java02.desafio_rocketseat_java_02.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//todo: tem que implementar a interface
@Component
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseMapper mapper;

    public List<CourseResponseDto> getCourses() {
        final var listCourses = repository.findAll();
        List<CourseResponseDto> listCoursesResponse = new ArrayList<>();
        for (Course course : listCourses) {
            listCoursesResponse.add(mapper.map(course));
        }
        return listCoursesResponse;
    }

    public List<Course> getByCategoryAndName(String category, String name) {
        return repository.findByCategoryAndNameAndActive(category, name, true);
    }
}
