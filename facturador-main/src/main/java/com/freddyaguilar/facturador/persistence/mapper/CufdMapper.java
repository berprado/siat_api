package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.RespuestaCufd;
import com.freddyaguilar.facturador.persistence.entity.CufdEntity;
import com.freddyaguilar.facturador.persistence.entity.PuntoVentaEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {CufdMapper.class})
public interface CufdMapper {

    CufdEntity toCufdEntity(RespuestaCufd respuestaCufd);
}
