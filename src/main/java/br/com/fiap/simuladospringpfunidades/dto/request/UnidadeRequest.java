package br.com.fiap.simuladospringpfunidades.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record UnidadeRequest(

        @NotNull(message = "O nome é Obrigatório")
        String nome,
        String sigla,
        String descricao,
        @Valid
        AbstractRequest macro
) {
}
