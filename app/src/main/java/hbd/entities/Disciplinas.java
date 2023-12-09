package hbd.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplinas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome_disciplina", length = 100)
    private String nomeDisciplina;

    public Disciplinas(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Long getIdDisciplina() {
        return id;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.id = idDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
