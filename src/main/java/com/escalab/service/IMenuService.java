package com.escalab.service;

import java.util.List;

import com.escalab.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);

}
