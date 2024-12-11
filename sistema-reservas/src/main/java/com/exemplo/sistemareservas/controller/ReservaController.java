package com.exemplo.sistemareservas.controller;

import com.exemplo.sistemareservas.dto.AlunoDTO;
import com.exemplo.sistemareservas.dto.LivroDTO;
import com.exemplo.sistemareservas.dto.ReservaDTO;
import com.exemplo.sistemareservas.model.Aluno;
import com.exemplo.sistemareservas.model.Livro;
import com.exemplo.sistemareservas.model.Reserva;
import com.exemplo.sistemareservas.repository.AlunoRepository;
import com.exemplo.sistemareservas.repository.LivroRepository;
import com.exemplo.sistemareservas.repository.ReservaRepository;
import com.exemplo.sistemareservas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

	 @Autowired
	    private AlunoRepository alunoRepository;

	    @Autowired
	    private LivroRepository livroRepository;

	    @Autowired
	    private ReservaService reservaService;
	    
	    @Autowired
	    private ReservaRepository reservaRepository;


	    @PostMapping("/criarReservas")
	    public ReservaDTO criarReserva(@RequestBody ReservaDTO reservaDTO) {
	        // Converter o DTO para a entidade Reserva
	        Reserva reserva = new Reserva();
	        reserva.setMatriculaAluno(reservaDTO.getMatriculaAluno());
	        reserva.setISBNLivro(reservaDTO.getIsbnLivro());
	        
	        reserva.setDataReserva(LocalDate.now());
	        reserva.setDataDevolucao(LocalDate.now().plusDays(7)); 
	        Reserva reservaSalva = reservaRepository.save(reserva);

	        // Retornar um novo DTO com os dados da Reserva salva
	        return new ReservaDTO(reservaSalva.getId(), reservaSalva.getMatriculaAluno(), reservaSalva.getISBNLivro());
	    }


    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }
    
    @PostMapping("/cadastrarAlunos")
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        
        Aluno aluno = new Aluno();
        aluno.setMatricula(alunoDTO.getMatricula());
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        
        Aluno alunoSalvo = alunoRepository.save(aluno);

        return new AlunoDTO(alunoSalvo.getMatricula(), alunoSalvo.getNome(), alunoSalvo.getEmail());
    }
    
    @GetMapping("/alunos")
    public List<AlunoDTO> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                     .map(aluno -> new AlunoDTO(aluno.getMatricula(), aluno.getNome(), aluno.getEmail()))
                     .collect(Collectors.toList());
    }

    @PostMapping("/cadastrarLivro")
    public LivroDTO cadastrarLivro(@RequestBody LivroDTO livroDTO) {
      
        Livro livro = new Livro();
        livro.setISBN(livroDTO.getISBN());
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setDisponivel(livroDTO.isDisponivel());

        if (livro.getISBN() == null || livro.getISBN().isEmpty()) {
            throw new IllegalArgumentException("O campo ISBN é obrigatório e deve ser preenchido.");
        }

        Livro livroSalvo = livroRepository.save(livro);

        return new LivroDTO(
                livroSalvo.getISBN(),
                livroSalvo.getTitulo(),
                livroSalvo.getAutor(),
                livroSalvo.isDisponivel()
        );
        
    }

    @GetMapping("/livros")
    public List<LivroDTO> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return livros.stream()
                     .map(livro -> new LivroDTO(
                         livro.getISBN(),     
                         livro.getTitulo(),    
                         livro.getAutor(),      
                         livro.isDisponivel() 
                     ))
                     .collect(Collectors.toList());
    }

}
