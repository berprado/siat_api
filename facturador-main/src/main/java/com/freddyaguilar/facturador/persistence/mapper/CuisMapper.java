package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.RespuestaCuis;
import com.freddyaguilar.facturador.persistence.entity.CuisEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {CuisMapper.class})
public interface CuisMapper {

    CuisEntity toCuisEntity(RespuestaCuis respuestaCuis);
}
