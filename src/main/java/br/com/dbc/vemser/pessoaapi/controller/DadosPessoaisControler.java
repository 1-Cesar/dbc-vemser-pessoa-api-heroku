package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDto;

import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@Validated
public class DadosPessoaisControler {

    @Autowired
    DadosPessoaisService dadosPessoaisService;

    @Operation(summary = "Traz todas as pessoas da API Dados Pessoais VemSer DBC", description = "recupera todos os registros presentes no banco de dados")
    @GetMapping
    public List<DadosPessoaisDto> getAll() {
        return dadosPessoaisService.list();
    }

    @Operation(summary = "Cria uma pessoa dentro da API VemSer DBC", description = "cria um registro de pessoa dentro do banco de dados")
    @PostMapping
    public DadosPessoaisDto post(@RequestBody DadosPessoaisDto pessoa) {
        return dadosPessoaisService.post(pessoa);
    }
}
