package github.marialluiza.demo.controller;

import github.marialluiza.demo.model.entity.Sala;
import github.marialluiza.demo.model.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping("/nova")
    public ResponseEntity<Boolean> novaSala(@RequestBody Sala sala) {
        salaService.novaSala(sala);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<List<Sala>> getSalas() {
        List<Sala> salas = salaService.getSalas();
        return ResponseEntity.ok(salas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaPorId(@PathVariable("id") Long id) {
        try {
            Sala sala = salaService.getSala(id);
            return ResponseEntity.ok(sala);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarSala(@PathVariable("id") Long id, @RequestBody Sala salaAtualizada) {
        try {
            Sala sala = salaService.editarSala(id, salaAtualizada);
            return ResponseEntity.ok(sala);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Erro: " + e.getMessage());
        }
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> deletarSala(@PathVariable("id") Long id) {
        try {
            salaService.deletarSala(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Erro: " + e.getMessage());
        }
    }
}