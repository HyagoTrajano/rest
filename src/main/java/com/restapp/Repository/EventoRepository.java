package com.restapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapp.Model.Evento;

public interface EventoRepository extends JpaRepository<Evento,Long> {

}
