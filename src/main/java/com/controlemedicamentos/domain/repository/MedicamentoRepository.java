package com.controlemedicamentos.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controlemedicamentos.domain.model.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
