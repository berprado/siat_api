package com.freddyaguilar.facturador.persistence.mapper;

import bo.gob.impuestos.siat.ActividadesDocumentoSectorDto;
import com.freddyaguilar.facturador.persistence.entity.ActividadDocumentoSectorEntity;
import org.mapstruct.Mapper;

/**
 * @author freddyar
 */
@Mapper(componentModel = "spring", uses = {ActividadDocumentoSectorMapper.class})
public interface ActividadDocumentoSectorMapper {

    ActividadDocumentoSectorEntity toActividadDocumentoSectorEntity(ActividadesDocumentoSectorDto actividadesDocumentoSectorDto);
}
