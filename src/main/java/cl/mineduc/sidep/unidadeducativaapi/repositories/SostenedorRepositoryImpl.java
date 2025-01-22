package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.mappers.SostenedorMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.SostenedorModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SostenedorRepositoryImpl implements SostenedorRepository {

    private final SostenedorMapper sostenedorMapper;

    @Override
    public SostenedorModel findById(Long id) {
        try {
            return this.sostenedorMapper.findById(id);
        } catch (Exception e) {
            log.error("Error al buscar sostenedor por id: {}", id, e);
            return null;
        }
    }

}

