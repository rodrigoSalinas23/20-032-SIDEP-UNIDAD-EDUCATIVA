package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.ProcesoEntity;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProcesoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProcesoServiceImpl implements ProcesoService {

    private final ProcesoRepository procesoRepository;

    @Transactional
    @Override
    public void save(ProcesoEntity procesoEntity) {
        this.procesoRepository.save(procesoEntity);
    }

}
