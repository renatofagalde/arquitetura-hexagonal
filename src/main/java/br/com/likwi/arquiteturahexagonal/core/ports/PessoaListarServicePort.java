package br.com.likwi.arquiteturahexagonal.core.ports;

import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;

import java.util.List;

public interface PessoaListarServicePort {
	List<PessoaDomain> listar(String tipo, String nome, PageManual pageable);


}
