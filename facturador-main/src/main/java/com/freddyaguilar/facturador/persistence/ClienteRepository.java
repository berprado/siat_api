package com.freddyaguilar.facturador.persistence;

import com.freddyaguilar.facturador.domain.repository.IClienteRepository;
import com.freddyaguilar.facturador.persistence.crud.ClienteCrudRepository;
import com.freddyaguilar.facturador.persistence.entity.ClienteEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author freddyar
 */
@Repository
public class ClienteRepository implements IClienteRepository {

    private final ClienteCrudRepository clienteCrudRepository;

    public ClienteRepository(ClienteCrudRepository clienteCrudRepository) {
        this.clienteCrudRepository = clienteCrudRepository;
    }

    @Override
    public Optional<ClienteEntity> findById(Integer id) {
        return this.clienteCrudRepository.findById(id);
    }
}
