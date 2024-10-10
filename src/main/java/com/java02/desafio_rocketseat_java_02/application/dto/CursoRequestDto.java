package com.java02.desafio_rocketseat_java_02.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDto(
        @NotBlank(message = "Nome não pode estar em branco ou vazio")
        String name,
        @NotBlank(message = "Categoria do curso não pode estar em branco ou vazia")
        String category,
        String active
) {
}
