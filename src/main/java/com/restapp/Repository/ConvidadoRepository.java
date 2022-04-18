package com.restapp.Repository;

import com.restapp.Model.Convidado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvidadoRepository extends JpaRepository<Convidado, Long>{
    
}
