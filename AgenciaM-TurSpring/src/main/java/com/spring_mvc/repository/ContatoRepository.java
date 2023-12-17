package com.spring_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_mvc.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
