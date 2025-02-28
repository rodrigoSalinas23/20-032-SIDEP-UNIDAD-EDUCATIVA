package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.FichaEstablecimientoMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
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
public class FichaEstablecimientoRepositoryImpl implements FichaEstablecimientoRepository {

    private final FichaEstablecimientoMapper fichaEstablecimientoMapper;

    @Override
    public List<FichaEstablecimientoModel> findAll() {
        try {
            return this.fichaEstablecimientoMapper.findAll();
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar todas las fichas de establecimiento");
        }
    }

    @Override
    public FichaEstablecimientoModel findById(Long id) {
        try {
            return this.fichaEstablecimientoMapper.findById(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar ficha de establecimiento por id: " + id);
        }
    }

    @Override
    public void save(FichaEstablecimientoEntity fichaEstablecimientoEntity) {
        try {
            this.fichaEstablecimientoMapper.insert(fichaEstablecimientoEntity);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al guardar ficha de establecimiento");
        }
    }

    @Override
    public void update(Long fichaEstablecimientoId, FichaEstablecimientoEntity fichaEstablecimientoEntity) {
        try {
            this.fichaEstablecimientoMapper.update(fichaEstablecimientoId, fichaEstablecimientoEntity);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al actualizar ficha de establecimiento");
        }
    }

    @Override
    public Boolean hasEstablecimiento(Long id) {
        try {
            return this.fichaEstablecimientoMapper.hasEstablecimiento(id);
        } catch (MyBatisSystemException e) {
            log.error(e.getMessage());
            throw new UnidadEducativaException("Error al buscar establecimiento por id: " + id);
        }
    }
}
