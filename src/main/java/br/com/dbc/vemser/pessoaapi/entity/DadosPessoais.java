package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoais {

    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private String tituloEleitor;
    private Genero sexo;

}
