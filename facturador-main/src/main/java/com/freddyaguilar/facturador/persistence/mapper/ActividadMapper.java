package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.ActividadesDto;
import com.freddyaguilar.facturador.persistence.entity.ActividadEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {ActividadMapper.class})
public interface ActividadMapper {

    ActividadEntity toActividadEntity(ActividadesDto actividadesDto);
}
