package cl.mineduc.sidep.unidadeducativaapi.repositories;


import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ProgramaMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProgramaRepositoryImpl implements ProgramaRepository {

    private final ProgramaMapper programaMapper;

    @Override
    public ProgramaModel findById(Long id) {
        try {
            return this.programaMapper.findById(id);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
            throw new SidepException("Error al buscar programa por id: " + id, e);
        }
    }

}
