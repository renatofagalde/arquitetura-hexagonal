package br.com.likwi.arquiteturahexagonal.adapters.handle.pessoaListar;

import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaListarServicePort;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class PessoaListarFactory implements PessoaListarHandle {

    @Autowired
    private BeanFactory beanFactory;

    @Override
    public List<PessoaDomain> listar(String tipo, String nome, PageManual pageManual) {

        PessoaListarServicePort query = this.beanFactory.getBean(tipo, PessoaListarServicePort.class);

        List<PessoaDomain> pessoas = query.listar(tipo,nome, pageManual);

        return pessoas;
    }
}
