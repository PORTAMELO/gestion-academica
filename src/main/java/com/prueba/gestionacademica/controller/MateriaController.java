package com.prueba.gestionacademica.controller;

import com.prueba.gestionacademica.model.Materia;
import com.prueba.gestionacademica.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<Materia>> buscarTodos(){
        return ResponseEntity.ok(materiaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(materiaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Materia> crearMateria(@RequestBody Materia materia){
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaService.crearMateria(materia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> actualizarMateria(@PathVariable Long id, @RequestBody Materia materia){
        return ResponseEntity.ok(materiaService.actualizarMateria(id, materia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Materia> eliminarMateria(@PathVariable Long id){
        materiaService.eliminarMateria(id);
        return ResponseEntity.ok().build();
    }

}
