package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
