package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Archivo;

public interface IArchivoRepo extends JpaRepository<Archivo, Integer> {
	
}
