package github.marialluiza.demo.model.service;

import github.marialluiza.demo.model.entity.Turma;
import github.marialluiza.demo.model.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository repository;

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

    public Turma editarTurma(Long id, Turma novosDados) throws Exception {
        Optional<Turma> turmaExistente = repository.findById(id);

        if (turmaExistente.isEmpty()) {
            throw new Exception("Turma não encontrada para edição");
        }

        Turma turmaAtual = turmaExistente.get();
        
        turmaAtual.setNome(novosDados.getNome());
        turmaAtual.setCodigo(novosDados.getCodigo());
        
        return repository.save(turmaAtual);
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