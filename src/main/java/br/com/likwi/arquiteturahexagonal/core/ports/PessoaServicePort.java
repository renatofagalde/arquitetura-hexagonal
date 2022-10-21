package br.com.likwi.arquiteturahexagonal.core.ports;

import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;

import java.util.List;

public interface PessoaServicePort {
	List<PessoaDomain> listar(String nome, PageManual pageable);

	PessoaDomain buscar(Long id);

	PessoaDomain salvar(PessoaDomain pessoa);

	PessoaDomain atualizar(Long id, PessoaDomain pessoa);
	
	void remover(Long id);
	
}
