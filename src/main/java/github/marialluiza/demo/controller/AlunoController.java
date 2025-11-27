package github.marialluiza.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import github.marialluiza.demo.model.entity.Aluno;
import github.marialluiza.demo.model.service.AlunoService;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;
    
    @PostMapping("/novo")
    public ResponseEntity<String> criarAluno(@RequestBody Aluno aluno) {
        alunoService.novoAluno(aluno);
        return ResponseEntity.status(201).body("Aluno criado com sucesso");
    }
    
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoService.getAlunos();
        return ResponseEntity.ok(alunos);    
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarAluno(@PathVariable Long id) {
        try {
            Aluno aluno = alunoService.getAluno(id);
            return ResponseEntity.ok(aluno);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        try {
            alunoService.atualizarAluno(id, aluno);
            return ResponseEntity.ok("Aluno atualizado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id) {
        try {
            alunoService.deletarAluno(id);
            return ResponseEntity.ok("Aluno deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
