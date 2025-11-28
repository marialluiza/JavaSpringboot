package github.marialluiza.demo.model.DTOs;

import github.marialluiza.demo.model.entity.Aluno;

public class AlunoResponseDTO {
    private Long id;
    private String nome;
    private String matricula;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

