package com.spring_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_mvc.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
