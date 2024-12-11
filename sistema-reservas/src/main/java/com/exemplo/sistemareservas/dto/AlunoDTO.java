package com.exemplo.sistemareservas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlunoDTO {

    @JsonProperty("matricula")
    private String matricula;

    private String nome;
    
    private String email;


    // Construtor sem argumentos
    public AlunoDTO() {}

    // Construtor com argumentos
    public AlunoDTO(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    @JsonProperty("matricula")
    public String getMatricula() {
        return matricula;
    }

    @JsonProperty("matricula")
    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
