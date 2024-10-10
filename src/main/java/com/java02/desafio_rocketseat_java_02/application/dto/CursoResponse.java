package com.java02.desafio_rocketseat_java_02.application.dto;

import java.time.LocalDateTime;

public record CursoResponse(
        String name,
        String category,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updateAt
) {
}
