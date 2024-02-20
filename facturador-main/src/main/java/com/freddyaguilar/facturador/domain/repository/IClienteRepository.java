package com.freddyaguilar.facturador.domain.repository;

import com.freddyaguilar.facturador.persistence.entity.ClienteEntity;

import java.util.Optional;

/**
 * @author freddyar
 */
public interface IClienteRepository {

    Optional<ClienteEntity> findById(Integer id);
}
