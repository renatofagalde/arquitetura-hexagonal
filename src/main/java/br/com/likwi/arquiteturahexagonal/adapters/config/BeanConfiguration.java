package br.com.likwi.arquiteturahexagonal.adapters.config;

import br.com.likwi.arquiteturahexagonal.ArquiteturaHexagonalApplication;
import br.com.likwi.arquiteturahexagonal.adapters.handle.pessoaListar.PessoaListarHandle;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaListarServicePort;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaPersistencePort;
import br.com.likwi.arquiteturahexagonal.core.services.PessoaListarServicePortImpl;
import br.com.likwi.arquiteturahexagonal.core.services.PessoaServicePortImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ArquiteturaHexagonalApplication.class)
public class BeanConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	PessoaServicePortImpl pessoaServicePortImpl(PessoaPersistencePort persistence){
		return new PessoaServicePortImpl(persistence);
	}

	@Bean
	PessoaListarServicePort pessoaListarServicePort(PessoaListarHandle pessoaListarHandle){
		return new PessoaListarServicePortImpl(pessoaListarHandle);
	}

}
