package github.marialluiza.demo.model.repository;

import github.marialluiza.demo.model.entity.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    Aluno searchByMatricula(String matricula);
}
