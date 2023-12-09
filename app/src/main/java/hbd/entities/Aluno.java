package hbd.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "alunos")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;
    @Column(name = "nome_aluno", length = 100)
    private String nome;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "cidade_natal", length = 50)
    private String cidadeNatal;

    public Aluno() {
    }

    public Aluno(String name, Date dataNascimento, String cidadeNatal) {
        this.nome = name;
        this.dataNascimento = dataNascimento;
        this.cidadeNatal = cidadeNatal;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCidadeNatal() {
        return cidadeNatal;
    }

    public void setCidadeNatal(String cidadeNatal) {
        this.cidadeNatal = cidadeNatal;
    }
}
