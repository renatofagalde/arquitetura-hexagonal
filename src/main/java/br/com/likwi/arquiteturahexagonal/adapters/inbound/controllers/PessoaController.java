package br.com.likwi.arquiteturahexagonal.adapters.inbound.controllers;


import br.com.likwi.arquiteturahexagonal.adapters.outbound.persistence.entities.PessoaEntity;
import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaServicePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    private final PessoaServicePort pessoaServicePort;

    public PessoaController(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    @GetMapping(value = "{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PessoaDomain>> pessoas(@PathVariable("nome") String nome,
                                                      @PageableDefault(page = 0, size = 10) Pageable pageable) {

        List<PessoaDomain> pessoas = this.pessoaServicePort.listar(nome,
                new PageManual(pageable.getPageSize(), pageable.getPageSize()));
        return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl<PessoaDomain>(pessoas, pageable, pessoas.size()));
    }


    @GetMapping(value = "/id/{pessoa_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDomain> buscar(@PathVariable("pessoa_id") Long pessoaId) {

        PessoaDomain pessoa = this.pessoaServicePort.buscar(pessoaId);
        return pessoa == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDomain> salvar(@RequestBody PessoaDomain pessoa) {

        pessoa = this.pessoaServicePort.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);

    }
}
