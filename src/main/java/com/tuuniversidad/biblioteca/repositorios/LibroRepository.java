package com.tuuniversidad.biblioteca.repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.tuuniversidad.biblioteca.modelos.Libro;

@Repository
public class LibroRepository {
    private List<Libro> libros = new ArrayList<>();

    public LibroRepository(){
        libros.add(new Libro(1, "Cien años de Soledad", "Gabriel Garcia Marquez", "Sudamericana"));
        libros.add(new Libro(2, "El retrato de Dorian Gray", "Oscar Wilde", "Alianza"));
        libros.add(new Libro(3, "El principito", "Antoine de Saint", "Gran Travesia"));
    }
    
    public List<Libro> findAll() {
        return libros;
    }

    public Optional<Libro> findById(Long id) {
        return libros.stream().filter(libro -> libro.getId().equals(id)).findFirst();
    }

    public void save(Libro libro) {
        libros.add(libro);
    }
}
