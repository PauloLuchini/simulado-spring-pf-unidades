package br.com.fiap.simuladospringpfunidades.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_PESSOA",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_PESSOA_EMAIL",
                        columnNames = {"EMAIL"}
                )
        })
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA")
    @SequenceGenerator(name = "SQ_PESSOA", sequenceName = "SQ_PESSOA", allocationSize = 1)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Column(name = "NOME_PESSOA")
    private String nome;

    @Column(name = "SOMBR_PESSOA")
    private String sobrenome;

    @Column(name = "EMAIL_PESSOA")
    private String email;

    @Column(name = "NASCI_PESSOA")
    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_PESSOA", nullable = false)
    private Tipo tipo;

}
