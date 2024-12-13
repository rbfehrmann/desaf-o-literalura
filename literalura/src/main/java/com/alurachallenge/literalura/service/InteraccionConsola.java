package com.alurachallenge.literalura.service;

import java.util.Scanner;

import com.alurachallenge.literalura.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InteraccionConsola {

    @Autowired
    private LibroService libroService;

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    buscarLibro(scanner);
                    break;
                case 2:
                    listarTodosLosLibros();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarLibrosPorIdioma(scanner);
                    break;
                case 5:
                    guardarLibro(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("¡BIENVENIDO A LITERALURA!");
        System.out.println("----- Menú -----");
        System.out.println("1. Buscar libro por título");
        System.out.println("2. Listar todos los libros");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Listar libros por idioma");
        System.out.println("5. Guardar libro");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void buscarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro que desea buscar: ");
        String titulo = scanner.nextLine();
        libroService.buscarLibrosEnAPI(titulo).forEach(System.out::println);
    }

    private void listarTodosLosLibros() {
        libroService.listarTodosLosLibros().forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        libroService.listarAutoresRegistrados().forEach(System.out::println);
    }

    private void listarLibrosPorIdioma(Scanner scanner) {
        System.out.print("Ingrese el idioma que desea buscar: ");
        String idioma = scanner.nextLine();
        libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
    }

    private void guardarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro que desea buscar: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro que desea buscar: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el idioma del libro que desea buscar: ");
        String idioma = scanner.nextLine();
        Libro libro = new Libro(titulo, autor, idioma);
        boolean resultado = libroService.guardarLibro(libro);
        if (resultado) {
            System.out.println("Libro guardado con éxito.");
        } else {
            System.out.println("Error al guardar el libro.");
        }
    }
}
