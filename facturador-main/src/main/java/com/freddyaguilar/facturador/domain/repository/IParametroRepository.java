package com.freddyaguilar.facturador.domain.repository;

import bo.gob.impuestos.siat.ParametricasDto;
import com.freddyaguilar.facturador.commons.ParametricaEnum;

/**
 * @author freddyar
 */
public interface IParametroRepository {

    void save(ParametricasDto parametricasDto, ParametricaEnum parametricaEnum);
    void deleteAll();
}
