package github.marialluiza.demo.model.service;

import github.marialluiza.demo.model.entity.Sala;
import github.marialluiza.demo.model.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;

    public boolean novaSala(Sala sala) {
        repository.save(sala);
        return true;
    }

    public List<Sala> getSalas() {
        Iterable<Sala> salas = repository.findAll();

        return (List<Sala>) salas;
    }

    public Sala getSala(Long id) throws Exception {
        Optional<Sala> sala = repository.findById(id);

        if (sala.isEmpty()) {
            throw new Exception("Sala não encontrada");
        }

        return sala.get();
    }

    public Sala editarSala(Long id, Sala dadosAtualizados) {
        Sala salaExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        salaExistente.setNumero(dadosAtualizados.getNumero());
        salaExistente.setCapacidade(dadosAtualizados.getCapacidade());
        salaExistente.setBloco(dadosAtualizados.getBloco());

        return repository.save(salaExistente);
    }


    public void deletarSala(Long id) {
        Sala sala = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));

        repository.delete(sala);
    }
}
