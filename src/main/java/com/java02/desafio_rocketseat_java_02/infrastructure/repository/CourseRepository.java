package com.java02.desafio_rocketseat_java_02.infrastructure.repository;

import com.java02.desafio_rocketseat_java_02.domain.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCategoryAndNameAndActive(String category, String name, Boolean active);
}
