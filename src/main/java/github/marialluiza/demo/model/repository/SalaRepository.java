package github.marialluiza.demo.model.repository;

import github.marialluiza.demo.model.entity.Sala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Long> {
    Sala searchByNumero(String numero);
}
