package github.marialluiza.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numero;
    private Integer capacidade;
    private String bloco;

    // mappedBy = "sala" refere-se ao atributo 'sala' na classe Turma
    @OneToMany(mappedBy = "sala")
    private List<Turma> turmas = new ArrayList<>();

    public Sala() {
    }

    public Sala(String numero, Integer capacidade, String bloco) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.bloco = bloco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
