package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {

    @Schema(description = "nome da pessoa.", example = "Cesar")
    @NotEmpty
    private String nome;

    @Schema(description = "data de nascimento da pessoa.", example = "1998-10-25")
    @NotNull
    @Past
    private LocalDate dataNascimento;

    @Schema(description = "cpf da pessoa.", example = "xxxxxxxxxxx")
    @CPF
    @NotEmpty
    private String cpf;

    @Schema(description = "email@email.com.br", example = "cesar@gmail.com.br")
    @NotBlank
    @Email
    private String email;
}
