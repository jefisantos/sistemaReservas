package com.exemplo.sistemareservas.repository;

import com.exemplo.sistemareservas.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, String> {
}
