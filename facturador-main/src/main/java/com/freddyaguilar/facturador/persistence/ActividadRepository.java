package com.freddyaguilar.facturador.persistence;

import bo.gob.impuestos.siat.ActividadesDto;
import com.freddyaguilar.facturador.domain.repository.IActividadRepository;
import com.freddyaguilar.facturador.persistence.crud.ActividadCrudRepository;
import com.freddyaguilar.facturador.persistence.mapper.ActividadMapper;
import org.springframework.stereotype.Repository;

/**
 * @author freddyar
 */
@Repository
public class ActividadRepository implements IActividadRepository {

    private final ActividadMapper actividadMapper;
    private final ActividadCrudRepository actividadCrudRepository;

    public ActividadRepository(ActividadMapper actividadMapper, ActividadCrudRepository actividadCrudRepository) {
        this.actividadMapper = actividadMapper;
        this.actividadCrudRepository = actividadCrudRepository;
    }

    @Override
    public void save(ActividadesDto actividadesDto) {
        this.actividadCrudRepository.save(this.actividadMapper.toActividadEntity(actividadesDto));
    }

    @Override
    public void deleteAll() {
        this.actividadCrudRepository.deleteAll();
    }
}
