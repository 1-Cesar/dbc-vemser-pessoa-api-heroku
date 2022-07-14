package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listById(Integer idPessoa) {
        return  pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaCreateDTO create(PessoaCreateDTO pessoa) {
        Pessoa id = pessoaRepository.create(objectMapper.convertValue(pessoa, Pessoa.class));
        //emailService.setEmailSender(id);
        emailService.sendEmail(objectMapper.convertValue(id, PessoaDTO.class), EnumEmail.CREATE);
        return objectMapper.convertValue(id, PessoaDTO.class);
    }

    public PessoaDTO update(Integer id,
                         PessoaDTO pessoaAtualizar) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = localizarPessoa(id);
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        emailService.sendEmail(objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class), EnumEmail.PUT);
        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = localizarPessoa(id);
        emailService.sendEmail(objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class),EnumEmail.DELETE);
        pessoaRepository.list().remove(pessoaRecuperada);
    }

    public Pessoa localizarPessoa (Integer idPessoa) throws RegraDeNegocioException {
        log.info("Verificando se existe registro de Pessoa.....");
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaRecuperada;
    }
}
