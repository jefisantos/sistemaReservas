package com.exemplo.sistemareservas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno {
    @Id
    private String matricula;
    private String nome;
    private String email;

    public String getMatricula() {
        return matricula;
    }

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
