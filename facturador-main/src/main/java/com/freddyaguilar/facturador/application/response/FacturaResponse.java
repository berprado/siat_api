package com.freddyaguilar.facturador.application.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author freddyar
 */
@Getter
@Setter
public class FacturaResponse {

    private Integer codigoEstado;
    private String cuf;
    private Long numeroFactura;
}
