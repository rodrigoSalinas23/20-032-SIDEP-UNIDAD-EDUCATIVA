package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;

import java.util.List;

public interface FichaEstablecimientoService {

    List<FichaEstablecimientoModel> findAll();

    FichaEstablecimientoModel findById(Long id);

    FichaEstablecimientoModel save(FichaEstablecimientoModel fichaEstablecimientoModel);

    FichaEstablecimientoModel update(Long fichaEstablecimiento, FichaEstablecimientoModel fichaEstablecimientoModel);

    default FichaEstablecimientoEntity toEntity(FichaEstablecimientoModel model) {
        FichaEstablecimientoEntity entity = new FichaEstablecimientoEntity();

        entity.setId(model.getId());
        entity.setEstablecimiento(model.getEstablecimiento() != null ? model.getEstablecimiento().getId() : null);
        entity.setSuperficieTerrenoM2(model.getSuperficieTerrenoM2());
        entity.setSuperficieEdificadaM2(model.getSuperficieEdificadaM2());
        entity.setNumeroSalas(model.getNumeroSalas());
        entity.setCapacidadSala(model.getCapacidadSala());
        entity.setCapacidadNivel(model.getCapacidadNivel());
        entity.setRuralidad(model.getRuralidad());
        entity.setNumeroPisos(model.getNumeroPisos());
        entity.setRolSii(model.getRolSii());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaActualizacion(model.getFechaActualizacion());

        return entity;
    }

}
