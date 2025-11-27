package github.marialluiza.demo.model.repository;

import github.marialluiza.demo.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario searchByNome(String nome);
}
