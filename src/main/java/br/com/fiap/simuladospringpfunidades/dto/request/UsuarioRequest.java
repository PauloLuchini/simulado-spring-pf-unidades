package br.com.fiap.simuladospringpfunidades.dto.request;

import br.com.fiap.simuladospringpfunidades.entity.Pessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UsuarioRequest(

        @NotNull(message = "O usuario é Obrigatório")
        String username,
        @NotNull(message = "A senha é Obrigatória")
        @Pattern(message = "A senha não atende aos requisitos", regexp = "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/")
        String password,

        @Valid
        @NotNull(message = "Informe o tipo da pessoa")
        Pessoa pessoaId
) {
}
