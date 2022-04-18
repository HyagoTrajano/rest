package com.restapp.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_evento")
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_evento;

    @NotEmpty
    private String tipo_festa;
    @NotEmpty
    private String data_festa;
    @NotEmpty
    private Integer sala_festa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="id_responsavel")
    private List<Responsavel> responsavel;
}
