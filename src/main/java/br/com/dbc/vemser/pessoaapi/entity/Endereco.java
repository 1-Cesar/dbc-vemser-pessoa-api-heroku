package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private Integer idPessoa;

    private Integer idEndereco;

    private EnumTipo tipo;

    private String logradouro;

    private String numero;

    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;
}
