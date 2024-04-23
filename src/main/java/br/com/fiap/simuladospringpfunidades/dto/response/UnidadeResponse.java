package br.com.fiap.simuladospringpfunidades.dto.response;

public record UnidadeResponse(

        Long id,
        String nome,
        String sigla,
        String descricao,
        Long macroId
) {
}
