package com.exemplo.sistemareservas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservaDTO {

    @JsonProperty("id")
    private Long id;

    private String matriculaAluno;
    private String isbnLivro;

    // Construtor sem argumentos
    public ReservaDTO() {}

    // Construtor com argumentos
    public ReservaDTO(Long id, String matriculaAluno, String isbnLivro) {
        this.id = id;
        this.matriculaAluno = matriculaAluno;
        this.isbnLivro = isbnLivro;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getIsbnLivro() {
        return isbnLivro;
    }

    public void setIsbnLivro(String isbnLivro) {
        this.isbnLivro = isbnLivro;
    }
}
