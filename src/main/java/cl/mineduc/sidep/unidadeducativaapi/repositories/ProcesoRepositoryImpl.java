package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.ProcesoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ProcesoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProcesoRepositoryImpl implements ProcesoRepository {

    private final ProcesoMapper procesoMapper;

    @Override
    public void save(ProcesoEntity procesoEntity) {
        try {
            this.procesoMapper.insert(procesoEntity);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
            throw new SidepException("Error al insertar proceso: " + procesoEntity, e);
        }
    }

}
