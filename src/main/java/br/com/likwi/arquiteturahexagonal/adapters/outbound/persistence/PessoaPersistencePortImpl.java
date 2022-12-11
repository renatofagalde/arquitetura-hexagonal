package br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence;

import br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence.entities.PessoaEntity;
import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaPersistencePort;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaPersistencePortImpl implements PessoaPersistencePort {

    private final PessoaJpaRepository pessoaJPARepository;
    private final ModelMapper modelMapper;

    public PessoaPersistencePortImpl(ModelMapper modelMapper, PessoaJpaRepository pessoaJPARepository) {
        this.pessoaJPARepository = pessoaJPARepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PessoaDomain> listar(String nome, PageManual pageManual) {
        Pageable pageable = PageRequest.of(pageManual.getPageNumber(), pageManual.getPageSize());

        return this.pessoaJPARepository.findAllByNome(nome, pageable)
                .stream()
                .map(entity -> this.modelMapper.map(entity, PessoaDomain.class))
                .collect(Collectors.toList());

    }

    @Override
    public PessoaDomain buscar(Long id) {

        return this.pessoaJPARepository.findById(id)
                .map(entity -> this.modelMapper.map(entity, PessoaDomain.class))
                .orElseThrow(() -> new ObjectNotFoundException(1,"Id não localizado"));

    }

    @Override
    public PessoaDomain salvar(PessoaDomain pessoa) {
//        PessoaEntity pessoaEntity = this.pessoaJPARepository.save(this.modelMapper.map(pessoa, PessoaEntity.class));
//        return this.modelMapper.map(pessoaEntity, PessoaDomain.class);

        return null;
    }

    @Override
    public PessoaDomain atualizar(Long id, PessoaDomain pessoa) {
        PessoaDomain pessoaDomain = this.salvar(pessoa);

        return pessoaDomain;
    }

    @Override
    public void remover(Long id) {
        this.pessoaJPARepository.deleteById(id);
    }
}
