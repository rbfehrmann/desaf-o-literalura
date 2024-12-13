package com.alurachallenge.literalura.service;

import com.alurachallenge.literalura.modelo.Libro;
import com.alurachallenge.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LibroRepository libroRepository;

    // Método para buscar libros en la API de Gutendex
    public List<Libro> buscarLibrosEnAPI(String titulo) {
        try {
            // URL base de la API con el parámetro de búsqueda
            String apiUrl = "https://gutendex.com/books?search=" + titulo;

            // Realiza la solicitud GET a la API y obtiene la respuesta como un Map
            Map<String, Object> response = restTemplate.getForObject(apiUrl, Map.class);

            // Extrae la lista de libros desde la clave "results"
            List<Map<String, Object>> books = (List<Map<String, Object>>) response.get("results");

            // Convierte los datos de la API en una lista de objetos Libro
            List<Libro> libros = new ArrayList<>();
            for (Map<String, Object> bookData : books) {
                String tituloLibro = (String) bookData.get("title");
                List<Map<String, Object>> authors = (List<Map<String, Object>>) bookData.get("authors");
                String autor = authors != null && !authors.isEmpty()
                        ? (String) authors.get(0).get("name")
                        : "Autor desconocido";
                String idioma = bookData.containsKey("languages")
                        ? ((List<String>) bookData.get("languages")).get(0)
                        : "Idioma desconocido";

                // Agregar libro a la lista
                libros.add(new Libro(tituloLibro, autor, idioma));
            }

            return libros;
        } catch (Exception e) {
            System.out.println("Error al consumir la API: " + e.getMessage());
            return List.of(); // Devuelve una lista vacía si ocurre un error
        }
    }

    // Lista todos los libros almacenados en la base de datos
    public List<Libro> listarTodosLosLibros() {
        try {
            return libroRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error al listar libros: " + e.getMessage());
            return List.of();
        }
    }

    // Lista todos los autores registrados sin duplicados
    public List<String> listarAutoresRegistrados() {
        try {
            return libroRepository.findAll().stream()
                    .map(Libro::getAutor)
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error al listar autores: " + e.getMessage());
            return List.of();
        }
    }

    // Lista libros filtrados por idioma
    public List<Libro> listarLibrosPorIdioma(String idioma) {
        try {
            return libroRepository.findByIdioma(idioma);
        } catch (Exception e) {
            System.out.println("Error al listar libros por idioma: " + e.getMessage());
            return List.of();
        }
    }

    // Guarda un libro en la base de datos
    public boolean guardarLibro(Libro libro) {
        try {
            libroRepository.save(libro);
            return true;
        } catch (Exception e) {
            System.out.println("Error al guardar el libro: " + e.getMessage());
            return false;
        }
    }

    public List<Libro> listarLibros() {
        return null;
    }
}
