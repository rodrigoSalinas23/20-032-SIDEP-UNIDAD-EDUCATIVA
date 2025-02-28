package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.EstablecimientoMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class EstablecimientoRepositoryImpl implements EstablecimientoRepository {

    private final EstablecimientoMapper establecimientoMapper;

    @Override
    public List<EstablecimientoModel> findAll() {
        try {
            return this.establecimientoMapper.findAll();
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new SidepException("Error al buscar establecimientos", e);
        }
    }

    @Override
    public EstablecimientoModel findById(Long id) {
        try {
            return this.establecimientoMapper.findById(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new SidepException("Error al buscar establecimiento", e);
        }
    }

    @Override
    public void save(EstablecimientoEntity establecimientoEntity) {
        try {
            this.establecimientoMapper.insert(establecimientoEntity);
        } catch (MyBatisSystemException ex){
            log.error(ex.getMessage(), ex);
            throw new SidepException("Error al guardar establecimiento", ex);
        }
    }

    @Override
    public void update(Long id, EstablecimientoEntity establecimientoEntity) {
        try {
            this.establecimientoMapper.update(id, establecimientoEntity);
        } catch (MyBatisSystemException ex){
            log.error(ex.getMessage(), ex);
            throw new SidepException("Error al actualizar establecimiento", ex);
        }
    }

    @Override
    public Boolean hasComuna(Long id) {
        try {
            return this.establecimientoMapper.hasComuna(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage(), e);
            throw new SidepException("Error al verificar si establecimiento tiene comuna", e);
        }
    }

}
