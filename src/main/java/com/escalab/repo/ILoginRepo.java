package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Usuario;

public interface ILoginRepo extends JpaRepository<Usuario, Integer> {
	
	// consultas por definir

}
