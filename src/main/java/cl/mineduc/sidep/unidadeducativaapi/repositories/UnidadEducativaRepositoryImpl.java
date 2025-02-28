package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.UnidadEducativaMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UnidadEducativaRepositoryImpl implements UnidadEducativaRepository {

    private final UnidadEducativaMapper unidadEducativaMapper;

    @Override
    public List<UnidadEducativaModel> findAll() {
        try {
            return unidadEducativaMapper.findAll();
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar todas las unidades educativas");
        }
    }

    @Override
    public UnidadEducativaModel findById(Long id) {
        try {
            return unidadEducativaMapper.findById(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar unidad educativa por id: " + id);
        }
    }

    @Override
    public UnidadEducativaModel findByRbd(Long rbd) {
        try{
            UnidadEducativaModel result = this.unidadEducativaMapper.findByRbd(rbd);
            log.info("Resultado del mapper: {}", result);
            return result;
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar unidad educativa por rbd: " + rbd);
        }
    }

    @Override
    public void save(UnidadEducativaEntity unidadEducativaEntity) {
        try {
            unidadEducativaMapper.insert(unidadEducativaEntity);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al crear unidad educativa", e );
        }
    }

    @Override
    public void update(Long rbd, UnidadEducativaEntity unidadEducativaEntity) {
        try {
            unidadEducativaMapper.update(rbd, unidadEducativaEntity);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al actualizar unidad educativa", e);
        }
    }

    @Override
    public Boolean hasMecanismoFinanciamiento(Long id) {
        try {
            return this.unidadEducativaMapper.hasMecanismoFinanciamiento(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar mecanismo de financiamiento", e);
        }
    }

    @Override
    public Boolean hasEstadoUnidadEducativa(Long id) {
        try {
            return this.unidadEducativaMapper.hasEstadoUnidadEducativa(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar estado de unidad educativa", e);
        }
    }

    @Override
    public Boolean hasGenero(Long id) {
        try {
            return this.unidadEducativaMapper.hasGenero(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar genero", e);
        }
    }

    @Override
    public Boolean hasEstadoFuncionamientoEnsenianza(Long id) {
        try {
            return this.unidadEducativaMapper.hasEstadoFuncionamientoEnsenianza(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar estado de funcionamiento de enseñanza", e);
        }
    }

    @Override
    public Boolean hasComuna(Long id) {
        try {
            return this.unidadEducativaMapper.hasComuna(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar comuna", e);
        }
    }

}
