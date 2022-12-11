package br.com.likwi.arquiteturahexagonal.adapters.inbound.controllers;


import br.com.likwi.arquiteturahexagonal.core.domain.PageManual;
import br.com.likwi.arquiteturahexagonal.core.domain.PessoaDomain;
import br.com.likwi.arquiteturahexagonal.core.ports.PessoaListarServicePort;
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
@RequestMapping(value = "/listar")
public class PessoaListarController {

    //setting spring.main.allow-circular-references
    private final PessoaListarServicePort pessoaListarServicePort;

    public PessoaListarController(PessoaListarServicePort pessoaListarServicePort) {
        this.pessoaListarServicePort = pessoaListarServicePort;
    }

    @GetMapping(value = "/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<PessoaDomain>> pessoas(@PathVariable("nome") String nome,
                                                      @RequestParam(value = "tipo", defaultValue = "M") String tipo,
                                                      @PageableDefault(page = 0, size = 10) Pageable pageable) {

        List<PessoaDomain> pessoas = this.pessoaListarServicePort.listar(tipo, nome,
                new PageManual(pageable.getPageNumber(), pageable.getPageSize()));
        return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl<PessoaDomain>(pessoas, pageable, pessoas.size()));
    }
}
