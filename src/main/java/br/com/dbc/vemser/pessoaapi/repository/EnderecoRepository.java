package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private AtomicInteger COUNTER2 = new AtomicInteger();

    public EnderecoRepository() {
        listEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*1*/, COUNTER2.incrementAndGet(),EnumTipo.RESIDENCIAL,"Rua Tuiuti","12","Casa","11111-111","São Paulo","SP", "Brasil"));
        listEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*2*/, COUNTER2.incrementAndGet(),EnumTipo.COMERCIAL,"Rua Tuiuti","13","APTO","22222-222","São Paulo","SP", "Brasil"));
        listEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*3*/, COUNTER2.incrementAndGet(),EnumTipo.RESIDENCIAL,"Rua Tuiuti","14","Casa","33333-333","São Paulo","SP", "Brasil"));
        listEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*4*/, COUNTER2.incrementAndGet(),EnumTipo.COMERCIAL,"Rua Tuiuti","15","APTO","44444-444","São Paulo","SP", "Brasil"));
        listEnderecos.add(new Endereco(COUNTER.incrementAndGet() /*5*/, COUNTER2.incrementAndGet(),EnumTipo.RESIDENCIAL,"Rua Tuiuti","16","Casa","55555-555","São Paulo","SP", "Brasil"));
    }

    public Endereco create(Integer id, Endereco endereco) {
        endereco.setIdPessoa(id);
        endereco.setIdEndereco(COUNTER2.incrementAndGet());
        listEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listEnderecos;
    }
}
