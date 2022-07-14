package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

/**
 * @author Cesar
 * @version vemSer - DBC
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    private String numero;

    private String descricao;

    private EnumTipo tipoContato;
}
