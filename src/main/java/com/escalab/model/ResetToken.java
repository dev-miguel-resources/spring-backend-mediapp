package com.escalab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ResetToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = false)
	private String token;
	
	@OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "id_usuario")
	private Usuario user;
	
	@Column(nullable = false)
	private LocalDateTime expiracion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public LocalDateTime getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(LocalDateTime expiracion) {
		this.expiracion = expiracion;
	}
	
	public void setExpiracion(int minutos) {
		LocalDateTime hoy = LocalDateTime.now();
		LocalDateTime exp = hoy.plusMinutes(minutos);
		this.expiracion = exp;
	}
	
	public boolean estaExpirado() {
		return LocalDateTime.now().isAfter(this.expiracion);
	}
}
