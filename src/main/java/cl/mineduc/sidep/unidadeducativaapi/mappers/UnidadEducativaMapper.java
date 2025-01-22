package cl.mineduc.sidep.unidadeducativaapi.mappers;


import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UnidadEducativaMapper {

    UnidadEducativaModel findById(Long id);

    UnidadEducativaModel findByRbd(@Param("rbd") Long rbd);

    List<UnidadEducativaModel> findAll();

    void insert(UnidadEducativaEntity unidadEducativaEntity);

    void update(@Param("rbd") Long rbd, @Param("ue") UnidadEducativaEntity unidadEducativaEntity);

    Boolean hasMecanismoFinanciamiento(Long id);

    Boolean hasEstadoUnidadEducativa(Long id);

    Boolean hasGenero(Long id);

    Boolean hasEstadoFuncionamientoEnsenianza(Long id);

    Boolean hasComuna(Long id);

}
