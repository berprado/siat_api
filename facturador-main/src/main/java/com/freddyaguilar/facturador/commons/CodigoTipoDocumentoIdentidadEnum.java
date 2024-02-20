package com.freddyaguilar.facturador.commons;

/**
 * @author freddyar
 */
public enum CodigoTipoDocumentoIdentidadEnum {

    CI(1),
    NIT(5);

    private final int value;

    CodigoTipoDocumentoIdentidadEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
