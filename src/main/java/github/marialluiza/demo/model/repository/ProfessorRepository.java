package github.marialluiza.demo.model.repository;

import github.marialluiza.demo.model.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    Professor searchByNome(String nome);
}
