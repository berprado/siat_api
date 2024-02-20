package com.freddyaguilar.facturador.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author freddyar
 */

@Getter
@Setter
@Entity
@Table(name = "punto_venta")
public class PuntoVentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer codigo;

    @NotEmpty
    private String nombre;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private SucursalEntity sucursal;
}
