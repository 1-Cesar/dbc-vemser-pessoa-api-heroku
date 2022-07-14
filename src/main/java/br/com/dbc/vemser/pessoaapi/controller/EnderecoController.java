package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;

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
@RequestMapping("/endereco")
@Validated
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Operation(summary = "listar endereços", description = "recupera todos os endereços do banco de dados")
    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        log.info("Mostrando todos os endereços");
        return ResponseEntity.ok(enderecoService.list());
    }

    @Operation(summary = "listar endereço por id", description = "recupera um endereço do banco de dados atraves de seu id")
    @GetMapping("/{idEndereco}")
    public ResponseEntity<List<EnderecoDTO>> listByIdEndereco (@PathVariable("idEndereco") int id) throws RegraDeNegocioException {
        log.info("Mostrando um único endereço por Id");
        return ResponseEntity.ok(enderecoService.listByIdEndereco(id));
    }

    @Operation(summary = "listar endereço por id da pessoa", description = "recupera um endereço do banco de dados atraves do id da pessoa")
    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa (@PathVariable("idPessoa") int id) throws RegraDeNegocioException {
        log.info("Mostrando um endereço filtrado por uma pessoa");
        return ResponseEntity.ok(enderecoService.listByIdPessoa(id));
    }

    @Operation(summary = "criar endereço atraves do id da pessoa", description = "cria um endereço dentro do banco de dados com base no id da pessoa")
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoCreateDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("Criando um endereço");
        return ResponseEntity.ok(enderecoService.create(id, endereco));
    }

    @Operation(summary = "altera um endereço por id", description = "altera os registros de um endereço no banco de dados atraves de seu id")
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                           @Valid @RequestBody EnderecoDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando um endereço");
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));
    }

    @Operation(summary = "deleta endereço", description = "deleta um endereço do banco de dados atraves de seu id")
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("Deletando um endereço");
        enderecoService.delete(id);
    }
}
