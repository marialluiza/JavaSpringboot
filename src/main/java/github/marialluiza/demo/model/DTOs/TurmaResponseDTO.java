package github.marialluiza.demo.model.DTOs;

import github.marialluiza.demo.model.entity.Turma;

import java.util.List;

public class TurmaResponseDTO {

    private Long id;
    private String nome;
    private String codigo;

    private ProfessorResponseDTO professor;
    private SalaResponseDTO sala;

    private List<AlunoResponseDTO> alunos;

    public TurmaResponseDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.codigo = turma.getCodigo();
        this.professor = new ProfessorResponseDTO(turma.getProfessor());
        this.sala = new SalaResponseDTO(turma.getSala());
        this.alunos = turma.getAlunos().stream()
                .map(AlunoResponseDTO::new)
                .toList();
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ProfessorResponseDTO getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorResponseDTO professor) {
        this.professor = professor;
    }

    public SalaResponseDTO getSala() {
        return sala;
    }

    public void setSala(SalaResponseDTO sala) {
        this.sala = sala;
    }

    public List<AlunoResponseDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoResponseDTO> alunos) {
        this.alunos = alunos;
    }
}
