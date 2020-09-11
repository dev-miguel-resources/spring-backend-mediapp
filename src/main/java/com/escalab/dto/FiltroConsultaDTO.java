package com.escalab.dto;

import java.time.LocalDateTime;

public class FiltroConsultaDTO {
	
	private String dni;
	private String nombreCompleto;
	private LocalDateTime fechaConsulta;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
}
