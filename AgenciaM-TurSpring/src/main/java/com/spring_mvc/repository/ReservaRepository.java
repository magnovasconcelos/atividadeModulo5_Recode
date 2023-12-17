package com.spring_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_mvc.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
