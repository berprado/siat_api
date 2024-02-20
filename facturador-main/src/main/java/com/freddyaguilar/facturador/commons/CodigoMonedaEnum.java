package com.freddyaguilar.facturador.commons;

/**
 * @author freddyar
 */
public enum CodigoMonedaEnum {

    BOLIVIANO(1);

    private final int value;

    CodigoMonedaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
