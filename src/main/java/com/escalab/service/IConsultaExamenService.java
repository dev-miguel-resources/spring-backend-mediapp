package com.escalab.service;

import java.util.List;

import com.escalab.model.ConsultaExamen;

public interface IConsultaExamenService  {
	
	
	List<ConsultaExamen> listarExamenesPorConsulta(Integer idConsulta);
	
	

}
