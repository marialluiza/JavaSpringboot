package github.marialluiza.demo.model.repository;

import github.marialluiza.demo.model.entity.Turma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Long> {
    Turma searchByNome(String nome);
}
