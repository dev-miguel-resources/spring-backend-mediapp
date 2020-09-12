package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Especialidad;
import com.escalab.repo.IEspecialidadRepo;
import com.escalab.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {
	
	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	public Especialidad registrar(Especialidad obj) {
		return repo.save(obj);
	}
	
	@Override
	public Especialidad modificar(Especialidad obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Especialidad> listar() {
		return repo.findAll();
	}
	
	@Override
	public Especialidad leerPorId(Integer id) {
		Optional<Especialidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Especialidad();
	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
