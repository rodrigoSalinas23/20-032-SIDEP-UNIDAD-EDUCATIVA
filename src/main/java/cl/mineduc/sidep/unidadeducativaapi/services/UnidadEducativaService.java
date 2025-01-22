package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;

import java.util.List;

public interface UnidadEducativaService {

    List<UnidadEducativaModel> findAll();

    UnidadEducativaModel findById(Long id);

    UnidadEducativaModel findByRbd(Long rbd);

    UnidadEducativaModel save(UnidadEducativaModel unidadEducativaModel);

    UnidadEducativaModel update(Long rbd, UnidadEducativaModel unidadEducativaModel);

    default UnidadEducativaEntity toEntity(UnidadEducativaModel model) {
        UnidadEducativaEntity entity = new UnidadEducativaEntity();

        entity.setNombre(model.getNombre());
        entity.setRbd(model.getRbd());
        entity.setDvRbd(model.getDvRbd());
        entity.setCodigoAreaTelefono(model.getCodigoAreaTelefono());
        entity.setTelefono(model.getTelefono());
        entity.setCelular(model.getCelular());
        entity.setMail(model.getMail());
        entity.setFechaInicioRo(model.getFechaInicioRo());
        entity.setFechaTerminoRo(model.getFechaTerminoRo());
        entity.setDependencia(model.getDependencia());
        entity.setSitioWeb(model.getSitioWeb());
        entity.setSoftwarePropio(model.getSoftwarePropio());
        entity.setAutorizaIntercambioCorreo(model.getAutorizaIntercambioCorreo());
        entity.setResolucion(model.getResolucion());
        entity.setFechaResolucion(model.getFechaResolucion());
        entity.setCodigoInstitucion(model.getCodigoInstitucion());
        entity.setComuna(model.getCodigoGeografico().getComuna().getId() != null ? model.getCodigoGeografico().getComuna().getId() : null);
        entity.setPrograma(model.getPrograma() != null ? model.getPrograma().getId() : null);
        entity.setModalidad(model.getModalidad() != null ? model.getModalidad().getId() : null);
        entity.setMecanismoFinanciamiento(model.getMecanismoFinanciamiento() != null ? model.getMecanismoFinanciamiento().getId() : null);
        entity.setSostenedor(model.getSostenedor() != null ? model.getSostenedor().getId() : null);
        entity.setEstadoUnidadEducativa(model.getEstadoUnidadEducativa() != null ? model.getEstadoUnidadEducativa().getId() : null);
        entity.setGenero(model.getGenero() != null ? model.getGenero().getId() : null);
        entity.setEstadoFuncionamientoEnsenianza(model.getEstadoFuncionamientoEnsenianza() != null ? model.getEstadoFuncionamientoEnsenianza().getId() : null);

        return entity;
    }

}
