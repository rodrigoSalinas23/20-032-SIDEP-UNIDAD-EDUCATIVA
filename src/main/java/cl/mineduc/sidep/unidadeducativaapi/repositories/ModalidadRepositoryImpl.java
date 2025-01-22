package cl.mineduc.sidep.unidadeducativaapi.repositories;


import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ModalidadMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.ModalidadModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ModalidadRepositoryImpl implements ModalidadRepository {

    private final ModalidadMapper modalidadMapper;

    @Override
    public ModalidadModel findById(Long id) {
        try {
            return this.modalidadMapper.findById(id);
        } catch (DataAccessException e) {
            log.error(e.getMessage());
            throw new SidepException("Error al buscar modalidad por id: " + id, e);
        }
    }

}
