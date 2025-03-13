package com.controlemedicamentos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlemedicamentos.domain.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
