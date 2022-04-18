package com.restapp.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_convidado")
@Getter
@Setter
public class Convidado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_convidado;

    @NotEmpty
    private String nome_convidado;
    @NotEmpty
    private String numero_convite;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Responsavel responsavel;
}
