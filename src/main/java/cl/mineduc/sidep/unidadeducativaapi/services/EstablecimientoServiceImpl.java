package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.EstablecimientoRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProcesoRepository;
import cl.mineduc.sidep.unidadeducativaapi.utils.ProcesoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstablecimientoServiceImpl implements EstablecimientoService {

    private final EstablecimientoRepository establecimientoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EstablecimientoModel> findAll() {
        return this.establecimientoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public EstablecimientoModel findById(Long id) {
        return this.establecimientoRepository.findById(id);
    }

    @Override
    @Transactional
    public EstablecimientoModel save(EstablecimientoModel model) {
        this.validateForeignKeys(model);

        EstablecimientoEntity entity = this.toEntity(model);
        this.establecimientoRepository.save(entity);

        model.setId(entity.getId());
        model.setFechaCreacion(entity.getFechaCreacion());

        return model;
    }

    @Override
    @Transactional
    public EstablecimientoModel update(Long id, EstablecimientoModel model) {
        this.validateForeignKeys(model);

        EstablecimientoEntity entity = this.toEntity(model);
        this.establecimientoRepository.update(id, entity);

        model.setId(id);

        return model;
    }

    /**
     * Método para validar las claves foráneas del modelo.
     *
     * @param model
     */
    private void validateForeignKeys(EstablecimientoModel model) {
        Long comunaId = model.getComuna().getId();
        Boolean hasComuna = this.establecimientoRepository.hasComuna(comunaId);
        if (Boolean.FALSE.equals(hasComuna)) {
            log.error("La comuna con ID {} no existe", model.getComuna());
            throw new UnidadEducativaException("La comuna con ID " + model.getComuna() + " no existe");
        }
    }

}
