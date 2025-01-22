package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.model.ModalidadModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ModalidadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ModalidadServiceImpl implements ModalidadService {

    private final ModalidadRepository modalidadRepository;

    @Override
    @Transactional(readOnly = true)
    public ModalidadModel findById(Long id) {
        return this.modalidadRepository.findById(id);
    }

}
