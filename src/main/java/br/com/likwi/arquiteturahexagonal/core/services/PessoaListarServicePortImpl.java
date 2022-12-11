package br.com.likwi.arquiteturahexagonal.core.services;

import br.com.likwi.arquiteturahexagonal.adapters.handle.pessoaListar.PessoaListarHandle;
import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaListarServicePort;

import java.util.List;


public class PessoaListarServicePortImpl implements PessoaListarServicePort {

	private final PessoaListarHandle pessoaListarHandle;

	public PessoaListarServicePortImpl(PessoaListarHandle pessoaListarHandle) {
		this.pessoaListarHandle = pessoaListarHandle;
	}

	@Override
	public List<PessoaDomain> listar(String tipo, String nome, PageManual pageable) {
		return this.pessoaListarHandle.listar(tipo, nome, pageable);
	}
}
