package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisService {

    @Autowired
    DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDto> list() {
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDto post(DadosPessoaisDto pessoa) {
        return dadosPessoaisClient.post(pessoa);
    }

}
