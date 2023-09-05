package mz.com.convidados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.com.convidados.model.Convidado;

public interface Convidados extends JpaRepository<Convidado, Long> {
	
}
