package com.mz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mz.app.model.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
