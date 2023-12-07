package hbd.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_item")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "it_id")
    private Long id;

    @Column(name = "it_titulo")
    private String titulo;

    @Column(name = "it_data")
    private LocalDateTime data;

    public Item() {
    }

    public Item(String titulo, LocalDateTime data) {
        this.titulo = titulo;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void print() {
        System.out.println("Item: " + this.getId() + " | " + this.getTitulo() + " | " + this.getData());
    }
}
