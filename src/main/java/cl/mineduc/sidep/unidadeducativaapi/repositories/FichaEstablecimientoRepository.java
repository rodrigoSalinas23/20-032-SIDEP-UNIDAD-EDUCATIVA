package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;

import java.util.List;

public interface FichaEstablecimientoRepository {

    List<FichaEstablecimientoModel> findAll();

    FichaEstablecimientoModel findById(Long id);

    void save(FichaEstablecimientoEntity fichaEstablecimientoEntity);

    void update(Long fichaEstablecimeintoId, FichaEstablecimientoEntity fichaEstablecimientoEntity);

    Boolean hasEstablecimiento(Long id);

}
