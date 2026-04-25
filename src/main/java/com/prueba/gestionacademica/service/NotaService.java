package com.prueba.gestionacademica.service;

import com.prueba.gestionacademica.model.Alumno;
import com.prueba.gestionacademica.model.Materia;
import com.prueba.gestionacademica.model.Nota;
import com.prueba.gestionacademica.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotaService {

    private final NotaRepository notaRepository;
    private final AlumnoService alumnoService;
    private final MateriaService materiaService;


    public List<Nota> buscarPorAlumno(Long alumnoId) {
        alumnoService.buscarPorId(alumnoId);
        return notaRepository.findByAlumnoId(alumnoId);
    }

    public Nota registrarNota(Long alumnoId, Long materiaId, Double valor){
        Alumno alumno = alumnoService.buscarPorId(alumnoId);
        Materia materia = materiaService.buscarPorId(materiaId);

        if(valor < 0 || valor > 5){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El valor de la nota debe estar entre 0.0 y 5.0");
        }

        Nota nota = Nota.builder()
                .alumno(alumno)
                .materia(materia)
                .valor(valor)
                .fechaRegistro(LocalDate.now())
                .build();

        return notaRepository.save(nota);

    }

}
