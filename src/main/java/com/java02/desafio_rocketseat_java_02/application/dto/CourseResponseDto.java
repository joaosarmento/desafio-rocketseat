package com.java02.desafio_rocketseat_java_02.application.dto;

import com.java02.desafio_rocketseat_java_02.application.annotations.Default;
import java.time.LocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CourseResponseDto {
  String name;
  String category;
  boolean active;
  LocalDateTime createdAt;
  LocalDateTime updatedAt;

  @Default
  public CourseResponseDto(
      final String name,
      final String category,
      final boolean active,
      final LocalDateTime createdAt,
      final LocalDateTime updatedAt) {
    this.name = name;
    this.category = category;
    this.active = active;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}
