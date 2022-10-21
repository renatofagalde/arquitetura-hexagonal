package br.com.likwi.arquiteturahexagonal.core.domain;

public class PessoaDomain {

    private Long id;

    private String nome;

    private String email;

    public Long getId() {
        return id;
    }

    public PessoaDomain(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}