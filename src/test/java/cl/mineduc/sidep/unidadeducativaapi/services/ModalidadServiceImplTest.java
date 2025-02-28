package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.model.ModalidadModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ModalidadRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ModalidadServiceImplTest {

    @Mock
    private ModalidadRepository modalidadRepository;

    @InjectMocks
    private ModalidadServiceImpl modalidadService;

    @Test
    public void findById_success() {
        ModalidadModel expected = new ModalidadModel();
        expected.setId(1L);
        expected.setNombre("Modalidad 1");

        when(modalidadRepository.findById(1L)).thenReturn(expected);

        ModalidadModel result = modalidadService.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }
}
