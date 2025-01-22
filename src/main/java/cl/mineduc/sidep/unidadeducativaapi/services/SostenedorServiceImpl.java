package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.model.SostenedorModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.SostenedorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SostenedorServiceImpl implements SostenedorService{

    private final SostenedorRepository sostenedorRepository;

    @Override
    @Transactional(readOnly = true)
    public SostenedorModel findById(Long id) {
        return this.sostenedorRepository.findById(id);
    }

}

