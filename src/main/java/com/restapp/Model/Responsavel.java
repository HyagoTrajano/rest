package com.restapp.Model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_responsavel")
@Getter
@Setter

public class Responsavel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_responsavel;

    @NotEmpty
    private String nome_responsavel;
    @NotEmpty
    private String cpf_cnpj;
    @NotEmpty
    private String email;

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Evento evento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="id_convidado")
    @JsonIgnore
    private List<Convidado> convidado;
}
