package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.ParametricaLeyendasDto;
import com.freddyaguilar.facturador.persistence.entity.LeyendaFacturaEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {LeyendaMapper.class})
public interface LeyendaMapper {

    LeyendaFacturaEntity toLeyendaFacturaEntity(ParametricaLeyendasDto parametricaLeyendasDto);
}
