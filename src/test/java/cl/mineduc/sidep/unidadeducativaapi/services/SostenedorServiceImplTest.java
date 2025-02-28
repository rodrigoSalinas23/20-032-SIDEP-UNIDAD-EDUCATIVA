package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.model.SostenedorModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.SostenedorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SostenedorServiceImplTest {

    @Mock
    private SostenedorRepository sostenedorRepository;

    @InjectMocks
    private SostenedorServiceImpl sostenedorService;

    @Test
    public void findById_success() {
        SostenedorModel expected = new SostenedorModel();
        expected.setId(1L);
        expected.setNombre("TEST");

        when(sostenedorRepository.findById(1L)).thenReturn(expected);

        SostenedorModel result = sostenedorService.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }
}
