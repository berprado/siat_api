package com.freddyaguilar.facturador.persistence;

import bo.gob.impuestos.siat.ParametricasDto;
import com.freddyaguilar.facturador.commons.ParametricaEnum;
import com.freddyaguilar.facturador.domain.repository.IParametroRepository;
import com.freddyaguilar.facturador.persistence.crud.ParametroCrudRepository;
import com.freddyaguilar.facturador.persistence.entity.ParametroEntity;
import com.freddyaguilar.facturador.persistence.mapper.ParametroMapper;
import org.springframework.stereotype.Repository;

/**
 * @author freddyar
 */
@Repository
public class ParametroRepository implements IParametroRepository {

    private final ParametroMapper parametroMapper;
    private final ParametroCrudRepository parametroCrudRepository;

    public ParametroRepository(ParametroMapper parametroMapper, ParametroCrudRepository parametroCrudRepository) {
        this.parametroMapper = parametroMapper;
        this.parametroCrudRepository = parametroCrudRepository;
    }

    @Override
    public void save(ParametricasDto parametricasDto, ParametricaEnum parametricaEnum) {
        ParametroEntity parametroEntity = this.parametroMapper.toParametroEntity(parametricasDto);
        parametroEntity.setCodigoTipoParametro(parametricaEnum.name());
        this.parametroCrudRepository.save(parametroEntity);
    }

    @Override
    public void deleteAll() {
        this.parametroCrudRepository.deleteAll();
    }
}
