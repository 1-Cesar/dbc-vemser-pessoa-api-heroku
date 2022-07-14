package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.Genero;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosPessoaisDto {

    @Schema(description = "CNH da pessoa.", example = "1231231123")
    @NotEmpty
    private String cnh;

    @Schema(description = "cpf da pessoa com 11 digitos sem pontos ou traços", example = "xxxxxxxxxxx")
    @NotEmpty
    private String cpf;

    @Schema(description = "nome da pessoa.", example = "Cesar")
    @NotEmpty
    private String nome;

    @Schema(description = "nome da mae da pessoa.", example = "Maria")
    @NotEmpty
    private String nomeMae;

    @Schema(description = "nome do pai da pessoa.", example = "Benedicto")
    @NotEmpty
    private String nomePai;

    @Schema(description = "rg da pessoa.", example = "111111111")
    @NotEmpty
    private String rg;

    @Schema(description = "titulo de eleitor da pessoa.", example = "987987897")
    @NotEmpty
    private String tituloEleitor;

    @Schema(description = "sexo da pessoa.", example = "M")
    @NotNull
    private Genero sexo;

}
