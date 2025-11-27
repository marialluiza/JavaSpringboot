package github.marialluiza.demo.model.service;

import github.marialluiza.demo.model.entity.Professor;
import github.marialluiza.demo.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public boolean novoProfessor(Professor professor) {
        repository.save(professor);
        return true;
    }

    public List<Professor> getProfessores() {
        Iterable<Professor> professores = repository.findAll();

        return (List<Professor>) professores;
    }

    public Professor getProfessor(Long id) throws Exception {
        Optional<Professor> professor = repository.findById(id);

        if (professor.isEmpty()) {
            throw new Exception("Professor não encontrado");
        }

        return professor.get();
    }

    public boolean atualizarProfessor(Long id, Professor professorAtualizado) throws Exception {
        Optional<Professor> professorExistente = repository.findById(id);

        if (professorExistente.isEmpty()) {
            throw new Exception("Professor não encontrado");
        }

        Professor professor = professorExistente.get();
        professor.setNome(professorAtualizado.getNome());
        professor.setDisciplina(professorAtualizado.getDisciplina());
        
        repository.save(professor);
        return true;
    }

    public boolean deletarProfessor(Long id) throws Exception {
        Optional<Professor> professor = repository.findById(id);

        if (professor.isEmpty()) {
            throw new Exception("Professor não encontrado");
        }

        repository.deleteById(id);
        return true;
    }
}
