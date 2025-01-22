package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;

import java.util.List;

public interface UnidadEducativaRepository {

    List<UnidadEducativaModel> findAll();

    UnidadEducativaModel findById(Long id);

    UnidadEducativaModel findByRbd(Long rbd);

    void save(UnidadEducativaEntity unidadEducativaEntity);

    void update(Long rbd, UnidadEducativaEntity unidadEducativaEntity);

    Boolean hasMecanismoFinanciamiento(Long id);

    Boolean hasEstadoUnidadEducativa(Long id);

    Boolean hasGenero(Long id);

    Boolean hasEstadoFuncionamientoEnsenianza(Long id);

    Boolean hasComuna(Long id);

}
