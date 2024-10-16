package com.java02.desafio_rocketseat_java_02.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CourseRequestDto(
        @NotBlank(message = "Course name cannot be blank or empty.")
        String name,
        @NotBlank(message = "Course category cannot be blank or empty.")
        String category,
        boolean active
) {
}
