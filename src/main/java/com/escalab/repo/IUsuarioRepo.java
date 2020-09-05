package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {

}
