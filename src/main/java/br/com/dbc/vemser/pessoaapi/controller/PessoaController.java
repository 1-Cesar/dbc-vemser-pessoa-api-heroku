package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.config.PropertieReader;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/pessoa")
@Validated
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PropertieReader propertieReader;

    @Autowired
    private EmailService emailService;

    /*@GetMapping("/ambiente")
    public String teste() {
        return propertieReader.getAmbiente();
    }*/

    @Value("${ola}")
    private String app;

    @Operation(summary = "listar pessoas", description = "recupera todas as pessoas do banco de dados")
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> list() {
        log.info("Mostrando todas as pessoas");
        return ResponseEntity.ok(pessoaService.list());
    }

    @Operation(summary = "listar pessoa por id", description = "recupera uma pessoa do banco de dados atraves de seu id")
    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<PessoaDTO>> listById (@PathVariable("idPessoa") int id) {
        log.info("Mostrando uma única pessoa por Id");
        return ResponseEntity.ok(pessoaService.listById(id));
    }

    @Operation(summary = "criar pessoa", description = "cria uma pessoa dentro do banco de dados")
    @PostMapping
    public ResponseEntity<PessoaCreateDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        log.info("Criando uma pessoa");
        return ResponseEntity.ok(pessoaService.create(pessoa));
        //return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.I_AM_TEAPOT
    }

    @Operation(summary = "altera uma pessoa por id", description = "altera os registros de uma pessoa no banco de dados atraves de seu id")
    @PutMapping("/{idPessoa}")
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                         @Valid @RequestBody PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando uma pessoa");
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizar));
    }

    @Operation(summary = "deleta pessoa", description = "deleta uma pessoa do banco de dados atraves de seu id")
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("Deletando uma pessoa");
        pessoaService.delete(id);
    }
}
