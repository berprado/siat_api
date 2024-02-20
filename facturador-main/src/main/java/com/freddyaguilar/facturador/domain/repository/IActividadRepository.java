package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.ActividadesDto;

/**
 * @author freddyar
 */
public interface IActividadRepository {

    void save(ActividadesDto actividadesDto);
    void deleteAll();
}
