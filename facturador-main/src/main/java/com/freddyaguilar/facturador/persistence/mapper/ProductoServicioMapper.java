package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.ProductosDto;
import com.freddyaguilar.facturador.persistence.entity.ProductoServicioEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {ProductoServicioMapper.class})
public interface ProductoServicioMapper {

    ProductoServicioEntity toActividadEntity(ProductosDto actividadDto);
}
