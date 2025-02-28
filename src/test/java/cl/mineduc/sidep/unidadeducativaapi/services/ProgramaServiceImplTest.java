package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProgramaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProgramaServiceImplTest {

    @Mock
    private ProgramaRepository programaRepository;

    @InjectMocks
    private ProgramaServiceImpl programaService;

    @Test
    public void findById_success() {
        ProgramaModel expected = new ProgramaModel();
        expected.setId(1L);
        expected.setNombre("TEST");

        when(programaRepository.findById(1L)).thenReturn(expected);

        ProgramaModel result = programaService.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }
}
