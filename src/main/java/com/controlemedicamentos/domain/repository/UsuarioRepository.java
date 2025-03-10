package com.controlemedicamentos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlemedicamentos.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Long, Usuario> {

}
