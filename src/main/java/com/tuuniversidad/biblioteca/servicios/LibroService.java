package com.tuuniversidad.biblioteca.servicios;

import com.tuuniversidad.biblioteca.modelos.Libro;
import com.tuuniversidad.biblioteca.repositorios.LibroRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LibroService {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    public void addLibro(Libro libro) {
        libroRepository.save(libro);
    }

}
