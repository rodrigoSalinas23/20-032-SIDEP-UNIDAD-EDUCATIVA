package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ProgramaMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProgramaRepositoryImplTest {

    @InjectMocks
    private ProgramaRepositoryImpl programaRepositoryImpl;

    @Mock
    private ProgramaMapper programaMapper;

    @Test
    public void testFindById_ReturnsModel() {
        ProgramaModel expected = new ProgramaModel();
        expected.setId(1L);
        when(programaMapper.findById(1L)).thenReturn(expected);

        ProgramaModel result = programaRepositoryImpl.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test(expected = SidepException.class)
    public void testFindById_Exception_ThrowsSidepException() {
        when(programaMapper.findById(1L))
                .thenThrow(new DataIntegrityViolationException("Error"));
        programaRepositoryImpl.findById(1L);
    }
}
