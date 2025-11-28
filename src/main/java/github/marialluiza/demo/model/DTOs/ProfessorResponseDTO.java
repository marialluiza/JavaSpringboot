package github.marialluiza.demo.model.DTOs;

import github.marialluiza.demo.model.entity.Professor;

public class ProfessorResponseDTO {
    private Long id;
    private String nome;
    private String disciplina;

    public ProfessorResponseDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.disciplina = professor.getDisciplina();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}

