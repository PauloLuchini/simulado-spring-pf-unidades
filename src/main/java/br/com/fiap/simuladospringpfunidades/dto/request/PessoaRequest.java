package br.com.fiap.simuladospringpfunidades.dto.request;

import br.com.fiap.simuladospringpfunidades.entity.Tipo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PessoaRequest(

        @Size(min = 2, max = 25)
        @NotNull(message = "O nome é Obrigatório")
        String nome,
        @Size(min = 3, max = 255)
        String sobrenome,
        @Email(message = "Email é inválido!")
        String email,
        @PastOrPresent(message = "Não pode ser uma data no futuro!")
        LocalDate nascimento,
        @NotNull(message = "Informe o tipo da pessoa")
        Tipo tipo
) {
}
