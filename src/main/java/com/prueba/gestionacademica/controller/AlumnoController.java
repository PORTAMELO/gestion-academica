package com.prueba.gestionacademica.controller;

import com.prueba.gestionacademica.model.Alumno;
import com.prueba.gestionacademica.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> buscarTodos() {
        return ResponseEntity.ok(alumnoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody Alumno alumno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.crearAlumno(alumno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.actualizarAlumno(id, alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }

}
