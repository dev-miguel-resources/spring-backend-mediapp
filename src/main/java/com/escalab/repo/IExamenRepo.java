package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Examen;

public interface IExamenRepo extends JpaRepository<Examen, Integer> {

}
