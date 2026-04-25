package com.prueba.gestionacademica.controller;

import com.prueba.gestionacademica.model.Nota;
import com.prueba.gestionacademica.service.MateriaService;
import com.prueba.gestionacademica.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notas")
@RequiredArgsConstructor
public class NotaController {

    private final NotaService notaService;

    @GetMapping("/alumno/{alumnoid}")
    public ResponseEntity<List<Nota>> buscarPorAlumno(@PathVariable() Long alumnoid) {
        return ResponseEntity.ok(notaService.buscarPorAlumno(alumnoid));
    }

    @PostMapping
    public ResponseEntity<Nota> registrarNota(@RequestBody RegistrarNotaRequest registrarNotaRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notaService.registrarNota(
                registrarNotaRequest.getAlumnoId(),
                registrarNotaRequest.getMateriaId(),
                registrarNotaRequest.getValor()
        ));
    }

    record RegistrarNotaRequest(Long alumnoId, Long materiaId, Double valor){
        public Long getAlumnoId() {
            return alumnoId;
        }
        public Long getMateriaId() {
            return materiaId;
        }
        public Double getValor() {
            return valor;
        }
    }

}
