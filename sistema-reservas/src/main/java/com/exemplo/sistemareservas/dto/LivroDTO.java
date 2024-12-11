package com.exemplo.sistemareservas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDTO {

    private String ISBN;

    private String titulo;
    private String autor;
    private boolean disponivel;

    // Construtor sem argumentos
    public LivroDTO() {}

    // Construtor com argumentos
    public LivroDTO(String ISBN, String titulo, String autor, boolean disponivel) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
    }

    @JsonProperty("ISBN")
    public String getISBN() {
        return ISBN;
    }
    
    @JsonProperty("ISBN")
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
