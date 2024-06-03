package com.tuuniversidad.biblioteca.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuuniversidad.biblioteca.modelos.Libro;
import com.tuuniversidad.biblioteca.modelos.LibroException;
import com.tuuniversidad.biblioteca.servicios.LibroService;

@RestController
@RequestMapping("/libro")

public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService){
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroporId(@PathVariable("id") Long id) {
        Optional<Libro> optionalLibro = libroService.getLibroById(id);
        if (optionalLibro.isEmpty()) {
            throw new LibroException("El libro con el ID "+  id  + " no se encuentra"); 
        }
        return new ResponseEntity<>(optionalLibro.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addLibro(@RequestBody Libro libro) {
        libroService.addLibro(libro);   
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}