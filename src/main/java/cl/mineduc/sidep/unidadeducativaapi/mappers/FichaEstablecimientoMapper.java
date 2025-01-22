package cl.mineduc.sidep.unidadeducativaapi.mappers;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FichaEstablecimientoMapper {

    List<FichaEstablecimientoModel> findAll();

    FichaEstablecimientoModel findById(Long id);

    void insert(FichaEstablecimientoEntity fichaEstablecimientoEntity);

    void update(@Param("id") Long id, @Param("fe") FichaEstablecimientoEntity fichaEstablecimientoEntity);

    Boolean hasEstablecimiento(Long id);

}
