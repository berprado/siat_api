package com.freddyaguilar.facturador.commons;

/**
 * @author freddyar
 */
public enum CodigoDocumentoSectorEnum {

    COMPRA_VENTA(1);

    private final int value;

    CodigoDocumentoSectorEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
