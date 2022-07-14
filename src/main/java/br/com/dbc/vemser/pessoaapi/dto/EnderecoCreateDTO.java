package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoCreateDTO {

    @Schema(description = "id da pessoa", example = "1")
    private Integer idPessoa;

    @Schema(description = "RESIDENCIAL OU COMERCIAL", example = "COMERCIAL")
    @NotNull(message = "informe o tipo do endereço (RESIDENCIAL ou COMERCIAL)")
    private EnumTipo tipo;

    @Schema(description = "Rua.....ou Avenida....", example = "Rua do Java")
    @NotBlank
    @Size(min = 6,max = 250)
    private String logradouro;

    @Schema(description = "numero do endereco", example = "123")
    @NotBlank
    private String numero;

    @Schema(description = "Casa, Apto, etc.", example = "Apto")
    private String complemento;

    @Schema(description = "CEP com 8 digitos sem pontos ou traços", example = "12345678")
    @NotBlank
    @Size(min = 8, max = 8)
    private String cep;

    @Schema(description = "cidade do endereco", example = "Cidade do Java")
    @NotBlank
    @Size(min = 3,max = 250)
    private String cidade;

    @Schema(description = "SP, RS, etc.", example = "SP")
    @NotBlank
    private String estado;

    @Schema(description = "País do endereco", example = "Javanês")
    @NotBlank
    private String pais;

}
