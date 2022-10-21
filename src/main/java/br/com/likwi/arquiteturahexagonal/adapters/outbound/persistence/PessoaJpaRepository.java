package br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence;

import br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence.entities.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, Long> {

	@Query("SELECT p FROM PessoaEntity p WHERE p.nome LIKE %:nome%")
	Page<PessoaEntity> buscarPorNome(String nome, Pageable pageable);


}
