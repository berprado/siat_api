package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.ParametricasDto;
import com.freddyaguilar.facturador.persistence.entity.ParametroEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {ParametroMapper.class})
public interface ParametroMapper {

    ParametroEntity toParametroEntity(ParametricasDto parametricasDto);
}
