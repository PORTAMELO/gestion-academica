package com.prueba.gestionacademica.service;

import com.prueba.gestionacademica.model.Alumno;
import com.prueba.gestionacademica.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public List<Alumno> buscarTodos() {
        return alumnoRepository.findAll();
    }

    public Alumno buscarPorId(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No existe un alumno con el id: " + id));
    }

    public Alumno crearAlumno(Alumno alumno) {
        if(alumnoRepository.existsByEmail(alumno.getEmail())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe un alumno con el email: " + alumno.getEmail()
            );
        }
        return alumnoRepository.save(alumno);
    }

    public Alumno actualizarAlumno(Long id, Alumno alumno) {
        Alumno existente = buscarPorId(id);
        existente.setNombre(alumno.getNombre());
        existente.setApellido(alumno.getApellido());
        existente.setEmail(alumno.getEmail());
        existente.setFechaNacimiento(alumno.getFechaNacimiento());
        return alumnoRepository.save(existente);
    }

    public void eliminarAlumno(Long id) {
        Alumno alumno = buscarPorId(id);
        alumnoRepository.delete(alumno);
    }

}
