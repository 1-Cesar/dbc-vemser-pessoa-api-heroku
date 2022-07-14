package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDto;

import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisService {

    @Autowired
    DadosPessoaisClient dadosPessoaisClient;

    public List<DadosPessoaisDto> list() throws RegraDeNegocioException {
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDto get(String cpf) throws RegraDeNegocioException {
        return dadosPessoaisClient.get(cpf);
    }

    public DadosPessoaisDto post(DadosPessoaisDto pessoa) throws RegraDeNegocioException {
        return dadosPessoaisClient.post(pessoa);
    }

    public DadosPessoaisDto put(String cpf, DadosPessoaisDto pessoaAtualizar) throws RegraDeNegocioException {
        return dadosPessoaisClient.put(cpf, pessoaAtualizar);
    }

    public void delete(String cpf)  throws RegraDeNegocioException {
        dadosPessoaisClient.delete(cpf);
    }


}
