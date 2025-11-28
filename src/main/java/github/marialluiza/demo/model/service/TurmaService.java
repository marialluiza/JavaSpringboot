package github.marialluiza.demo.model.service;

import github.marialluiza.demo.model.DTOs.TurmaDTO;
import github.marialluiza.demo.model.entity.Aluno;
import github.marialluiza.demo.model.entity.Professor;
import github.marialluiza.demo.model.entity.Sala;
import github.marialluiza.demo.model.entity.Turma;
import github.marialluiza.demo.model.repository.AlunoRepository;
import github.marialluiza.demo.model.repository.ProfessorRepository;
import github.marialluiza.demo.model.repository.SalaRepository;
import github.marialluiza.demo.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public boolean novaTurma(Turma turma) {
        repository.save(turma);
        return true;
    }

    public Turma getTurmaPorId(Long id) throws Exception {
        Optional<Turma> turma = repository.findById(id);

        if (turma.isEmpty()) {
            throw new Exception("Turma não encontrada");
        }

        return turma.get();
    }

    public List<Turma> getTurmas() {
        Iterable<Turma> turmas = repository.findAll();

        return (List<Turma>) turmas;
    }

    public Turma editarTurma(Long id, TurmaDTO dto) throws Exception {

        Turma turma = repository.findById(id)
                .orElseThrow(() -> new Exception("Turma não encontrada"));

        turma.setNome(dto.getNome());
        turma.setCodigo(dto.getCodigo());

        Professor professor = professorRepository.findById(dto.getIdProfessor())
                .orElseThrow(() -> new Exception("Professor não encontrado"));
        turma.setProfessor(professor);

        Sala sala = salaRepository.findById(dto.getIdSala())
                .orElseThrow(() -> new Exception("Sala não encontrada"));
        turma.setSala(sala);

        Iterable<Aluno> iterableAlunos = alunoRepository.findAllById(dto.getIdsAlunos());
        List<Aluno> alunos = new ArrayList<>();
        iterableAlunos.forEach(alunos::add);
        turma.setAlunos(alunos);

        return repository.save(turma);
    }

    public Boolean apagarTurma(Long id) throws Exception {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new Exception("Turma não existe");
        }
    }
}