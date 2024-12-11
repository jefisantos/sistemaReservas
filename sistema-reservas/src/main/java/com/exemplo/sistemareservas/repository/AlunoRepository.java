package com.exemplo.sistemareservas.repository;

import com.exemplo.sistemareservas.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
