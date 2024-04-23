package br.com.fiap.simuladospringpfunidades.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_USUARIO",uniqueConstraints = {
        @UniqueConstraint(
                name = "UK_USERNAME",
                columnNames = {"USER_USUARIO"}),
        @UniqueConstraint(
                name = "UK_USER_PESSOA",
                columnNames = {"PESSOA"})
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "USER_USUARIO")
    private String username;

    @Column(name = "SENHA_USUARIO")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(
                    name = "FK_USUARIO_PESSOA"
            )
    )
    private Pessoa pessoa;
}
