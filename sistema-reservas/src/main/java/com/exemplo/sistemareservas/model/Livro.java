package com.exemplo.sistemareservas.model;

import com.exemplo.sistemareservas.dto.LivroDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livro {

    @Id
    private String ISBN; 

    private String titulo;
    private String autor;
    private boolean disponivel;

    public String getISBN() {
        return ISBN;
    }

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
    
    public LivroDTO toDTO() {
        LivroDTO dto = new LivroDTO();
        dto.setISBN(this.ISBN);
        dto.setTitulo(this.titulo);
        dto.setAutor(this.autor);
        dto.setDisponivel(this.disponivel);
        return dto;
    }

    public static Livro fromDTO(LivroDTO dto) {
        Livro livro = new Livro();
        livro.setISBN(dto.getISBN());
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setDisponivel(dto.isDisponivel());
        return livro;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "ISBN='" + ISBN + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
