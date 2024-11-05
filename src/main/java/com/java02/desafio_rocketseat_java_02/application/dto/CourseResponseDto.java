package com.java02.desafio_rocketseat_java_02.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.java02.desafio_rocketseat_java_02.application.annotations.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class CourseResponseDto {
    private Long id;
    private String name;
    private String category;
    private Boolean active;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @Default
    public CourseResponseDto(final Long id, final String name, final String category, final Boolean active, final LocalDateTime createdAt, final LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
