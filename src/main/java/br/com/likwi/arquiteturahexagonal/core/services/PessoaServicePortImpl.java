package br.com.likwi.arquiteturahexagonal.core.services;

import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaPersistencePort;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaServicePort;

import java.util.List;


public class PessoaServicePortImpl implements PessoaServicePort {

	private final PessoaPersistencePort pessoaPersistencePort;

	public PessoaServicePortImpl(PessoaPersistencePort pessoaPersistencePort) {
		this.pessoaPersistencePort = pessoaPersistencePort;
	}


	@Override
	public List<PessoaDomain> listar(String nome, PageManual pageable) {
		return this.pessoaPersistencePort.listar(nome, pageable);
	}

	@Override
	public PessoaDomain buscar(Long id) {
		return this.pessoaPersistencePort.buscar(id);
	}

	@Override
	public PessoaDomain salvar(PessoaDomain pessoa) {
		return this.pessoaPersistencePort.salvar(pessoa);
	}

	@Override
	public PessoaDomain atualizar(Long id, PessoaDomain pessoa) {
		return this.pessoaPersistencePort.atualizar(id, pessoa);
	}

	@Override
	public void remover(Long id) {
		this.pessoaPersistencePort.remover(id);
	}
}
