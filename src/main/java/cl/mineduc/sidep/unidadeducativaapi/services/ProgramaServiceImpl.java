package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProgramaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProgramaServiceImpl implements ProgramaService {

    private final ProgramaRepository programaRepository;

    @Override
    public ProgramaModel findById(Long id) {
        return this.programaRepository.findById(id);
    }

}
