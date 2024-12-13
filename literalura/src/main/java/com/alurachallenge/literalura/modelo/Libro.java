package com.alurachallenge.literalura.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 255, message = "El título no puede exceder 255 caracteres")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    private String autor;

    private String descripcion;

    @NotBlank(message = "El ISBN no puede estar vacío")
    private String isbn;

    @NotBlank(message = "El idioma no puede estar vacío")
    private String idioma;

    public Libro(String titulo, String autor, String idioma) {
    }

    public Libro(String titulo, String autor, String descripcion, String isbn, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.isbn = isbn;
        this.idioma = idioma;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", isbn='" + isbn + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}



