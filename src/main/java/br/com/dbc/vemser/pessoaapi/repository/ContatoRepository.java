package br.com.dbc.vemser.pessoaapi.repository;
/**
 * @author Cesar
 * @version vemSer - DBC
 */
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.EnumTipo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ContatoRepository {
    private static List<Contato> listContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private AtomicInteger COUNTER2 = new AtomicInteger();

    public ContatoRepository() {
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, COUNTER2.incrementAndGet(), "1111-1111","Whatsapp", EnumTipo.COMERCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, COUNTER2.incrementAndGet(), "2222-2222","Telegram", EnumTipo.RESIDENCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, COUNTER2.incrementAndGet(), "3333-3333","Whatsapp", EnumTipo.COMERCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, COUNTER2.incrementAndGet(), "4444-4444","Whatsapp", EnumTipo.RESIDENCIAL));
        listContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, COUNTER2.incrementAndGet(), "5555-5555","Telegram", EnumTipo.COMERCIAL));
    }

    public Contato create(Integer id, Contato contato) {
        contato.setIdPessoa(id);
        contato.setIdContato(COUNTER.incrementAndGet());
        listContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listContatos;
    }

}
