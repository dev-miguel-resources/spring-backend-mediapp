package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Menu;

public interface IMenuRepo extends JpaRepository<Menu, Integer> {
	
	// consulta por definir

}
