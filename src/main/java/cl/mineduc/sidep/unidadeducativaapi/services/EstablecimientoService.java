package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;

import java.util.List;

public interface EstablecimientoService {

    List<EstablecimientoModel> findAll();

    EstablecimientoModel findById(Long id);

    EstablecimientoModel save(EstablecimientoModel model);

    EstablecimientoModel update(Long id, EstablecimientoModel model);

    default EstablecimientoEntity toEntity(EstablecimientoModel model) {
        EstablecimientoEntity entity = new EstablecimientoEntity();

        entity.setId(model.getId());
        entity.setComuna(model.getComuna() != null ? model.getComuna().getId() : null);
        entity.setDireccion(model.getDireccion());
        entity.setDireccionNumero(model.getDireccionNumero());
        entity.setDireccionReferencia(model.getDireccionReferencia());
        entity.setCodigoPostal(model.getCodigoPostal());
        entity.setLatitud(model.getLatitud());
        entity.setLongitud(model.getLongitud());
        entity.setTipologia(model.getTipologia());
        entity.setModalidadAtencion(model.getModalidadAtencion());
        entity.setFechaCreacion(model.getFechaCreacion());
        entity.setFechaActualizacion(model.getFechaActualizacion());

        return entity;
    }

}
