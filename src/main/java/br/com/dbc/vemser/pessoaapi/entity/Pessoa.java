package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Integer idPessoa;

    //@Getter(AccessLevel.NONE) -> ignorando get para nome
    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private String email;
}
