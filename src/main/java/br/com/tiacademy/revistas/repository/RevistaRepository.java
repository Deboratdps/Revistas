package br.com.tiacademy.revistas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.revistas.domain.Revista;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {
	
}
