package br.com.dbc.vemser.pessoaapi.controller;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;

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
@RequestMapping("/contato")
@Validated
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @Operation(summary = "listar contatos", description = "recupera todos os contatos do banco de dados")
    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        log.info("Mostrando todos os contatos");
        return ResponseEntity.ok(contatoService.list());
    }

    @Operation(summary = "listar contato por id", description = "recupera um contato do banco de dados atraves de seu id")
    @GetMapping("/{idContato}")
    public ResponseEntity<List<ContatoDTO>> listById (@PathVariable("idContato") int id) throws RegraDeNegocioException {
        log.info("Mostrando um único contato");
        return ResponseEntity.ok(contatoService.listById(id));
    }

    @Operation(summary = "criar contato atraves do id da pessoa", description = "cria um contato dentro do banco de dados com base no id da pessoa")
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoCreateDTO> create(@PathVariable("idPessoa") Integer id, @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("Criando um contato");
        return ResponseEntity.ok(contatoService.create(id, contato));
    }

    @Operation(summary = "altera um contato por id", description = "altera os registros de um contato no banco de dados atraves de seu id")
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoDTO contatoAtualizar) throws RegraDeNegocioException {
        log.info("Atualizando um contato");
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @Operation(summary = "deleta contato", description = "deleta um contato do banco de dados atraves de seu id")
    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws RegraDeNegocioException {
        log.info("Deletando um contato");
        contatoService.delete(id);
    }
}
