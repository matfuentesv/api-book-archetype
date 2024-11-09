package cl.company.service;

import cl.company.model.EntityModel;

import java.util.List;

public interface EntityService {

    List<EntityModel> findAll();
    EntityModel findEntity(Long id);
    EntityModel createEntity(EntityModel entityModel);
    EntityModel updateEntity(EntityModel entityModel);
    void deleteEntity(Long id);
}
