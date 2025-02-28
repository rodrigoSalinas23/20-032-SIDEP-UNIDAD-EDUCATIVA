package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.model.ModalidadModel;
import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;
import cl.mineduc.sidep.unidadeducativaapi.model.SostenedorModel;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProcesoRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProgramaRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.SostenedorRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.UnidadEducativaRepository;
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
public class UnidadEducativaServiceImpl implements UnidadEducativaService {

    private final UnidadEducativaRepository unidadEducativaRepository;
    private final SostenedorRepository sostenedorRepository;
    private final ProcesoRepository procesoRepository;
    private final ModalidadService modalidadService;
    private final ProgramaRepository programaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UnidadEducativaModel> findAll() {
        return this.unidadEducativaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public UnidadEducativaModel findById(Long id) {
        return this.unidadEducativaRepository.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public UnidadEducativaModel findByRbd(Long rbd) {
        return this.unidadEducativaRepository.findByRbd(rbd);
    }

    @Override
    @Transactional
    public UnidadEducativaModel save(UnidadEducativaModel model) {
        validateForeignKeys(model);

        UnidadEducativaEntity entity = this.toEntity(model);
        this.unidadEducativaRepository.save(entity);

        model.setId(entity.getId());
        model.setFechaCreacion(entity.getFechaCreacion());

        return model;
    }

    @Override
    @Transactional
    public UnidadEducativaModel update(Long rbd, UnidadEducativaModel model) {
        UnidadEducativaModel educativaModel = this.unidadEducativaRepository.findByRbd(rbd);
        if (educativaModel == null) {
            log.error("La unidad educativa con RBD {} no existe", rbd);
            throw new UnidadEducativaException("La unidad educativa con RBD " + rbd + " no existe");
        }

        validateForeignKeys(model);

        UnidadEducativaEntity entity = this.toEntity(model);
        this.unidadEducativaRepository.update(rbd, entity);

        model.setId(entity.getId());
        model.setFechaCreacion(entity.getFechaCreacion());
        model.setFechaActualizacion(entity.getFechaActualizacion());

        return model;
    }

    /**
     * Método para validar las claves foráneas del modelo.
     *
     * @param model
     */
    private void validateForeignKeys(UnidadEducativaModel model) {
        if (model.getSostenedor() != null && model.getSostenedor().getId() != null) {
            Long sostenedorId = model.getSostenedor().getId();
            if (sostenedorRepository.findById(sostenedorId) == null) {
                log.error("El sostenedor con ID {} no existe", sostenedorId);
                throw new UnidadEducativaException("El sostenedor con ID " + sostenedorId + " no existe");
            }
        }

        if (model.getCodigoGeografico() != null && model.getCodigoGeografico().getComuna() != null && model.getCodigoGeografico().getComuna().getId() != null) {
            Long comunaId = model.getCodigoGeografico().getComuna().getId();
            if (Boolean.FALSE.equals(unidadEducativaRepository.hasComuna(comunaId))) {
                log.error("La comuna con ID {} no existe", comunaId);
                throw new UnidadEducativaException("La comuna con ID " + comunaId + " no existe");
            }
        }

        if (model.getModalidad() != null && model.getModalidad().getId() != null) {
            Long modalidadId = model.getModalidad().getId();
            if (modalidadService.findById(modalidadId) == null) {
                log.error("La modalidad con ID {} no existe", modalidadId);
                throw new UnidadEducativaException("La modalidad con ID " + modalidadId + " no existe");
            }
        }

        if (model.getPrograma() != null && model.getPrograma().getId() != null) {
            Long programaId = model.getPrograma().getId();
            if (programaRepository.findById(programaId) == null) {
                log.error("El programa con ID {} no existe", programaId);
                throw new UnidadEducativaException("El programa con ID " + programaId + " no existe");
            }
        }

        if (model.getMecanismoFinanciamiento() != null && model.getMecanismoFinanciamiento().getId() != null) {
            Long mecanismoFinanciamientoId = model.getMecanismoFinanciamiento().getId();
            if (Boolean.FALSE.equals(unidadEducativaRepository.hasMecanismoFinanciamiento(mecanismoFinanciamientoId))) {
                log.error("El mecanismo de financiamiento con ID {} no existe", mecanismoFinanciamientoId);
                throw new UnidadEducativaException("El mecanismo de financiamiento con ID " + mecanismoFinanciamientoId + " no existe");
            }
        }

        if (model.getEstadoUnidadEducativa() != null && model.getEstadoUnidadEducativa().getId() != null) {
            Long estadoUnidadEducativaId = model.getEstadoUnidadEducativa().getId();
            if (Boolean.FALSE.equals(unidadEducativaRepository.hasEstadoUnidadEducativa(estadoUnidadEducativaId))) {
                log.error("El estado de la unidad educativa con ID {} no existe", estadoUnidadEducativaId);
                throw new UnidadEducativaException("El estado de la unidad educativa con ID " + estadoUnidadEducativaId + " no existe");
            }
        }

        if (model.getGenero() != null && model.getGenero().getId() != null) {
            Long generoId = model.getGenero().getId();
            if (Boolean.FALSE.equals(unidadEducativaRepository.hasGenero(generoId))) {
                log.error("El género con ID {} no existe", generoId);
                throw new UnidadEducativaException("El género con ID " + generoId + " no existe");
            }
        }

        if (model.getEstadoFuncionamientoEnsenianza() != null && model.getEstadoFuncionamientoEnsenianza().getId() != null) {
            Long estadoFuncionamientoEnsenianzaId = model.getEstadoFuncionamientoEnsenianza().getId();
            if (Boolean.FALSE.equals(unidadEducativaRepository.hasEstadoFuncionamientoEnsenianza(estadoFuncionamientoEnsenianzaId))) {
                log.error("El estado de funcionamiento de la enseñanza con ID {} no existe", estadoFuncionamientoEnsenianzaId);
                throw new UnidadEducativaException("El estado de funcionamiento de la enseñanza con ID " + estadoFuncionamientoEnsenianzaId + " no existe");
            }
        }
    }

}
