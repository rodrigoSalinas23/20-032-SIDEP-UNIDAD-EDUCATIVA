package cl.mineduc.sidep.unidadeducativaapi.mappers;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EstablecimientoMapper {

    EstablecimientoModel findById(Long id);

    List<EstablecimientoModel> findAll();

    void insert(EstablecimientoEntity establecimientoModel);

    void update(@Param("id") Long id, @Param("e") EstablecimientoEntity establecimientoModel);

    Boolean hasComuna(Long id);

}
