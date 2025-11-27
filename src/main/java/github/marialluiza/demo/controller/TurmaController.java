package github.marialluiza.demo.controller;

import github.marialluiza.demo.model.entity.Turma;
import github.marialluiza.demo.model.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping("/nova")
    public ResponseEntity<Boolean> novaTurma(@RequestBody Turma turma) {
        turmaService.novaTurma(turma);
        return ResponseEntity.status(201).body(true);
    }

    @GetMapping
    public ResponseEntity<Iterable<Turma>> getTurmas() {
        Iterable<Turma> turmas = turmaService.getTurmas();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaPorId(@PathVariable("id") Long id) {
        try {
            Turma turma = turmaService.getTurmaPorId(id);
            return ResponseEntity.ok(turma);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
        try {
            Turma turmaAtualizada = turmaService.editarTurma(id, turma);
            return ResponseEntity.ok(turmaAtualizada);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Erro: " + e.getMessage());
        }
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<?> apagarTurma(@PathVariable("id") Long id) {
        try {
            turmaService.apagarTurma(id);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Erro ao apagar: " + e.getMessage());
        }
    }
}