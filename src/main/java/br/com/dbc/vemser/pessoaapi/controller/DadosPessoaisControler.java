package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDto;

import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;

import io.swagger.v3.oas.annotations.Operation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/dados-pessoais")
@Validated
public class DadosPessoaisControler {

    @Autowired
    DadosPessoaisService dadosPessoaisService;

    @Operation(summary = "Traz todas as pessoas da API Dados Pessoais VemSer DBC", description = "recupera todos os registros presentes no banco de dados")
    @GetMapping
    public List<DadosPessoaisDto> getAll() throws RegraDeNegocioException{
        return dadosPessoaisService.list();
    }

    @Operation(summary = "Traz uma única pessoa da API Dados Pessoais VemSer DBC", description = "recupera uma pessoa do banco de dados através de seu cpf")
    @GetMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDto> get(@PathVariable("cpf") String cpf) throws RegraDeNegocioException {
        log.info("Trazendo uma pessoa através do CPF na API VemSer");
        return ResponseEntity.ok(dadosPessoaisService.get(cpf));
    }

    @Operation(summary = "Cria uma pessoa dentro da API Dados Pessoais VemSer DBC", description = "cria um registro de pessoa dentro do banco de dados")
    @PostMapping
    public ResponseEntity<DadosPessoaisDto> post(@Valid @RequestBody DadosPessoaisDto pessoa) throws RegraDeNegocioException {
        log.info("Registrando uma pessoa na API VemSer");
        return ResponseEntity.ok(dadosPessoaisService.post(pessoa));
    }

    @Operation(summary = "Altera uma pessoa dentro da API Dados Pessoais VemSer DBC", description = "altera registros através do cpf da pessoa")
    @PutMapping("/{cpf}")
    public ResponseEntity<DadosPessoaisDto> put(@PathVariable("cpf") String cpf,
                                @Valid @RequestBody DadosPessoaisDto atualizarPessoa) throws RegraDeNegocioException {
        log.info("Atualizando uma pessoa dentro da API VemSer com base no CPF");
        return ResponseEntity.ok(dadosPessoaisService.put(cpf, atualizarPessoa));
    }

    @Operation(summary = "Deleta uma pessoa dentro da API Dados Pessoais VemSer DBC", description = "deleta uma pessoa dentro do banco de dados com base no cpf desta pessoa")
    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) throws RegraDeNegocioException {
        log.info("Deletando uma pessoa dentro da API VemSer com base no CPF");
        dadosPessoaisService.delete(cpf);
    }
}
