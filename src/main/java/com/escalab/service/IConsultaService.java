package com.escalab.service;

import java.util.List;

import com.escalab.dto.ConsultaListaExamenDTO;
import com.escalab.dto.ConsultaResumenDTO;
import com.escalab.dto.FiltroConsultaDTO;
import com.escalab.model.Consulta;

public interface IConsultaService extends ICRUD<Consulta> {
	
	Consulta registrarTransaccional(ConsultaListaExamenDTO dto);
	
	List<Consulta> buscar(FiltroConsultaDTO filtro);
	
	List<Consulta> buscarFecha(FiltroConsultaDTO filtro);
	
	List<ConsultaResumenDTO> listarResumen();
	
	byte[] generarReporte();
	

}
