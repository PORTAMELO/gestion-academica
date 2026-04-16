package com.prueba.gestionacademica.repository;

import com.prueba.gestionacademica.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    boolean existsByEmail(String email);

}
