package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Medico;
import com.escalab.repo.IMedicoRepo;
import com.escalab.service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService {
	
	@Autowired
	private IMedicoRepo repo;
	
	@Override
	public Medico registrar(Medico obj) {
		return repo.save(obj);
	}
	
	@Override
	public Medico modificar(Medico obj) {
		return repo.save(obj);
	}
	
	@Override
	public List<Medico> listar() {
		return repo.findAll();
	}
	
	@Override
	public Medico leerPorId(Integer id) {
		Optional<Medico> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Medico();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}
}
