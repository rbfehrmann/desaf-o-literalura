package com.alurachallenge.literalura.controller;

import com.alurachallenge.literalura.modelo.Libro;
import com.alurachallenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    // 1. Obtener todos los libros
    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    // 2. Crear un nuevo libro
    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroRepository.save(libro);
        return ResponseEntity.ok(nuevoLibro);
    }

    // 3. Buscar libros por idioma
    @GetMapping("/idioma/{idioma}")
    public List<Libro> buscarPorIdioma(@PathVariable String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    // 4. Listar autores únicos
    @GetMapping("/autores")
    public List<String> listarAutoresUnicos() {
        return libroRepository.findDistinctAutores();
    }

    // 5. Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}