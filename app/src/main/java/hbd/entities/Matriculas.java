package hbd.entities;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "matriculas")
@Entity
public class Matriculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_matriculas")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplinas disciplinas;

    @Column(name = "data_matricula")
    private Date dataMatriculas;

    public Matriculas(Aluno aluno, Disciplinas disciplinas, Date dataMatriculas) {
        this.aluno = aluno;
        this.disciplinas = disciplinas;
        this.dataMatriculas = dataMatriculas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplinas getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplinas disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Date getDataMatriculas() {
        return dataMatriculas;
    }

    public void setDataMatriculas(Date dataMatriculas) {
        this.dataMatriculas = dataMatriculas;
    }
}
