package github.marialluiza.demo.controller;

import github.marialluiza.demo.model.entity.Professor;
import github.marialluiza.demo.model.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/novo")
    public ResponseEntity<String> criarProfessor(@RequestBody Professor professor) {
        professorService.novoProfessor(professor);
        return ResponseEntity.status(201).body("Professor criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        List<Professor> professores = professorService.getProfessores();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProfessor(@PathVariable Long id) {
        try {
            Professor professor = professorService.getProfessor(id);
            return ResponseEntity.ok(professor);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        try {
            professorService.atualizarProfessor(id, professor);
            return ResponseEntity.ok("Professor atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProfessor(@PathVariable Long id) {
        try {
            professorService.deletarProfessor(id);
            return ResponseEntity.ok("Professor deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
