package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.FichaEstablecimientoRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProcesoRepository;
import cl.mineduc.sidep.unidadeducativaapi.utils.ProcesoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FichaEstablecimientoServiceImpl implements FichaEstablecimientoService {

    private final FichaEstablecimientoRepository fichaEstablecimientoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<FichaEstablecimientoModel> findAll() {
        return this.fichaEstablecimientoRepository.findAll();
    }

    @Override
    public FichaEstablecimientoModel findById(Long id) {
        return this.fichaEstablecimientoRepository.findById(id);
    }

    @Override
    @Transactional
    public FichaEstablecimientoModel save(FichaEstablecimientoModel model) {
        validateForeignKeys(model);

        FichaEstablecimientoEntity entity = this.toEntity(model);
        this.fichaEstablecimientoRepository.save(entity);

        model.setId(entity.getId());
        model.setFechaCreacion(entity.getFechaCreacion());

        return model;
    }

    @Override
    @Transactional
    public FichaEstablecimientoModel update(Long fichaEstablecimiento, FichaEstablecimientoModel fichaEstablecimientoModel) {
        validateForeignKeys(fichaEstablecimientoModel);

        FichaEstablecimientoEntity entity = this.toEntity(fichaEstablecimientoModel);
        this.fichaEstablecimientoRepository.update(fichaEstablecimiento, entity);

        fichaEstablecimientoModel.setId(fichaEstablecimiento);
        fichaEstablecimientoModel.setFechaActualizacion(entity.getFechaActualizacion());

        return fichaEstablecimientoModel;
    }

    /**
     * Método para validar las claves foráneas del modelo.
     *
     * @param model
     */
    private void validateForeignKeys(FichaEstablecimientoModel model) {

        if (model.getEstablecimiento() != null && model.getEstablecimiento().getId() != null) {
            Long establecimientoId = model.getEstablecimiento().getId();
            if (Boolean.FALSE.equals(this.fichaEstablecimientoRepository.hasEstablecimiento(establecimientoId))) {
                log.error("No existe establecimiento con id: {}", establecimientoId);
                throw new UnidadEducativaException("No existe establecimiento con id: " + establecimientoId);
            }
        }

    }

}
