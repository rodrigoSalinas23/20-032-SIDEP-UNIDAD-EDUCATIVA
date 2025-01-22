package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;

public interface ProgramaRepository {

    ProgramaModel findById(Long id);

}
