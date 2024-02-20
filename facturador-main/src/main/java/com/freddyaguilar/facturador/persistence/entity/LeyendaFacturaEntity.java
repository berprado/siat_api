package com.freddyaguilar.facturador.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author freddyar
 */

@Getter
@Setter
@Entity
@Table(name = "leyenda_factura")
public class LeyendaFacturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String codigoActividad;

    private String descripcionLeyenda;
}
