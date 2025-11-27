package github.marialluiza.demo.model.service;

import github.marialluiza.demo.model.entity.Aluno;
import github.marialluiza.demo.model.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public boolean novoAluno(Aluno aluno) {
        repository.save(aluno);
        return true;
    }

    public List<Aluno> getAlunos() {
        Iterable<Aluno> alunos = repository.findAll();
        
        return (List<Aluno>) alunos;
    }

    public Aluno getAluno(Long id) throws Exception {
        Optional<Aluno> aluno = repository.findById(id);

        if (aluno.isEmpty()) {
            throw new Exception("Aluno não encontrado");
        }

        return aluno.get();
    }

    public boolean atualizarAluno(Long id, Aluno alunoAtualizado) throws Exception {
        Optional<Aluno> alunoExistente = repository.findById(id);

        if (alunoExistente.isEmpty()) {
            throw new Exception("Aluno não encontrado");
        }

        Aluno aluno = alunoExistente.get();
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setMatricula(alunoAtualizado.getMatricula());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setTurmas(alunoAtualizado.getTurmas());
        
        repository.save(aluno);
        return true;
    }

    public boolean deletarAluno(Long id) throws Exception {
        Optional<Aluno> aluno = repository.findById(id);

        if (aluno.isEmpty()) {
            throw new Exception("Aluno não encontrado");
        }

        repository.deleteById(id);
        return true;
    }
}