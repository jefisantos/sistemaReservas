package com.exemplo.sistemareservas.service;

import com.exemplo.sistemareservas.model.Aluno;
import com.exemplo.sistemareservas.model.Livro;
import com.exemplo.sistemareservas.model.Reserva;
import com.exemplo.sistemareservas.repository.AlunoRepository;
import com.exemplo.sistemareservas.repository.LivroRepository;
import com.exemplo.sistemareservas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva realizarReserva(String matriculaAluno, String ISBNLivro) {
        Aluno aluno = alunoRepository.findById(matriculaAluno)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Livro livro = livroRepository.findById(ISBNLivro)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if (!livro.isDisponivel()) {
            throw new RuntimeException("Livro não está disponível para reserva.");
        }

        Reserva reserva = new Reserva();
        reserva.setMatriculaAluno(matriculaAluno);
        reserva.setISBNLivro(ISBNLivro);
        reserva.setDataReserva(LocalDate.now());
        reserva.setDataDevolucao(LocalDate.now().plusDays(7));

        livro.setDisponivel(false);
        livroRepository.save(livro);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }
}
