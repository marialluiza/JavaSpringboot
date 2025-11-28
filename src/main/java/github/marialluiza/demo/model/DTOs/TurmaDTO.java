package github.marialluiza.demo.model.DTOs;

import java.util.List;

public class TurmaDTO {

    private String nome;
    private String codigo;

    private Long idProfessor;
    private Long idSala;
    private List<Long> idsAlunos;

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

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public List<Long> getIdsAlunos() {
        return idsAlunos;
    }

    public void setIdsAlunos(List<Long> idsAlunos) {
        this.idsAlunos = idsAlunos;
    }
}

