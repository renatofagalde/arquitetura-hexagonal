package br.com.likwi.arquiteturahexagonal.adapters.handle.pessoaListar;


import br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence.PessoaJpaRepository;
import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("M")
public class PessoaListarMasculinoHandle implements PessoaListarHandle{

    private final PessoaJpaRepository pessoaJPARepository;

    public PessoaListarMasculinoHandle(PessoaJpaRepository pessoaJPARepository) {
        this.pessoaJPARepository = pessoaJPARepository;
    }

    @Override
    public List<PessoaDomain> listar(String tipo, String nome, PageManual pageManual) {
        Pageable pageable = PageRequest.of(pageManual.getPageNumber(), pageManual.getPageSize());

        return this.pessoaJPARepository.findMale(pageable)
                .stream()
                .map(entity -> new PessoaDomain(entity.getId(), entity.getNome(), entity.getEmail(), entity.getSexo()))
                .collect(Collectors.toList());

    }
}
