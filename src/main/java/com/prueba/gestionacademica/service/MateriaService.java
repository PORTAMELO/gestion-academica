package com.prueba.gestionacademica.service;
import com.prueba.gestionacademica.model.Materia;
import com.prueba.gestionacademica.repository.MateriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public List<Materia> buscarTodos(){
        return materiaRepository.findAll();
    }

    public Materia buscarPorId(Long id) {
        return materiaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No existe una materia con el id: " + id));
    }

    public Materia crearMateria(Materia materia) {
        if(materiaRepository.existsByCodigo(materia.getCodigo())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ya existe una materia con el codigo: " + materia.getCodigo()
            );
        }
        return materiaRepository.save(materia);
    }

    public Materia actualizarMateria(Long id, Materia materia) {

        Materia existente = buscarPorId(id);

        existente.setNombre(materia.getNombre());
        existente.setCodigo(materia.getCodigo());
        existente.setCreditos(materia.getCreditos());
        return materiaRepository.save(existente);

    }

    public void eliminarMateria(Long id) {
        Materia materia = buscarPorId(id);
        materiaRepository.delete(materia);
    }

}
