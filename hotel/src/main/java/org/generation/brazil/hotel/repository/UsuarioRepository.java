package org.generation.brazil.hotel.repository;

import java.util.List;

import org.generation.brazil.hotel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	// criando uma busca personalizada no banco de dados
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
}
