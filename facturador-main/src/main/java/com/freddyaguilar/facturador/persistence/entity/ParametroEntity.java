package com.freddyaguilar.facturador.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author freddyar
 */

@Getter
@Setter
@Entity
@Table(name = "parametro")
public class ParametroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String codigoClasificador;

    @NotNull
    private String descripcion;

    @NotNull
    private String codigoTipoParametro;
}
