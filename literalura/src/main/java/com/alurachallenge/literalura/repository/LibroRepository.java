package com.alurachallenge.literalura.repository;

import com.alurachallenge.literalura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT DISTINCT l.autor FROM Libro l")
    List<String> findDistinctAutores();

    List<Libro> findByIdioma(String idioma);
}
