package br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence;

import br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence.entities.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, Long> {

	@Query("FROM PessoaEntity p WHERE p.nome like %:nome%")
	Page<PessoaEntity> findAllByNome(@Param("nome") String nome, Pageable pageable);

	@Query("FROM PessoaEntity p WHERE p.sexo = 'M' and p.nome like %:nome%")
	Page<PessoaEntity> findMale(@Param("nome") String nome, Pageable pageable);

	@Query("FROM PessoaEntity p WHERE p.sexo = 'F' and p.nome like %:nome%")
	Page<PessoaEntity> findFemale(@Param("nome") String nome, Pageable pageable);

}
