package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;

import java.util.List;

public interface EstablecimientoRepository {

    List<EstablecimientoModel> findAll();

    EstablecimientoModel findById(Long id);

    void save(EstablecimientoEntity establecimientoEntity);

    void update(Long id, EstablecimientoEntity establecimientoEntity);

    Boolean hasComuna(Long id);

}
