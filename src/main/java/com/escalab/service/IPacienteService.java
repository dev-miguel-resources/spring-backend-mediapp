package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escalab.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente> {
	
	Page<Paciente> listarPageable(Pageable pageable);

}
