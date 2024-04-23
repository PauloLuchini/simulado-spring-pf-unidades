package br.com.fiap.simuladospringpfunidades.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ChefeRequest(

        Boolean substituto,
        @Valid
        @NotNull(message = "Informe o usuário")
        AbstractRequest usuario,
        @Valid
        @NotNull(message = "Informe a unidade")
        AbstractRequest unidade,
        LocalDateTime inicio,
        LocalDateTime fim
) {
}
