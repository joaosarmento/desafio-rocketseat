package com.java02.desafio_rocketseat_java_02.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.AllArgsConstructor;

@ToString
@Value
@EqualsAndHashCode
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CourseRequestDto {
    @NotBlank(message = "Course name cannot be blank or empty.")
    String name;
    @NotBlank(message = "Course category cannot be blank or empty.")
    String category;
    Boolean active;
}
