package com.java02.desafio_rocketseat_java_02.application.service.mappers;

import com.java02.desafio_rocketseat_java_02.application.dto.CourseResponseDto;
import com.java02.desafio_rocketseat_java_02.domain.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseResponseDto map(Course course);
}
