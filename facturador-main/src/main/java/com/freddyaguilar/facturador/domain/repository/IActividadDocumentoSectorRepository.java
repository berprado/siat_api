package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.ActividadesDocumentoSectorDto;

/**
 * @author freddyar
 */
public interface IActividadDocumentoSectorRepository {

    void save(ActividadesDocumentoSectorDto actividadesDocumentoSectorDto);

    void deleteAll();
}
