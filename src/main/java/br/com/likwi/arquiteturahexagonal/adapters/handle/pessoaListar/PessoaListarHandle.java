package br.com.likwi.arquiteturahexagonal.adapters.handle.pessoaListar;

import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;

import java.util.List;

public interface PessoaListarHandle {

    List<PessoaDomain> listar(String tipo, String nome, PageManual pageManual);
}
