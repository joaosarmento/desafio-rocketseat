package com.java02.desafio_rocketseat_java_02.application.dto;

import com.java02.desafio_rocketseat_java_02.application.annotations.Default;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CourseResponseDto{
        private Long id;
        private String name;
        private String category;
        private Boolean active;
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;

        @Default
        public CourseResponseDto(final Long id, final String name, final String category, final Boolean active, final LocalDateTime createdAt, final LocalDateTime updateAt) {
                this.id = id;
                this.name = name;
                this.category = category;
                this.active = active;
                this.createdAt = createdAt;
                this.updateAt = updateAt;
        }
}
