package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ModalidadMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.ModalidadModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ModalidadRepositoryImplTest {

    @InjectMocks
    private ModalidadRepositoryImpl modalidadRepositoryImpl;

    @Mock
    private ModalidadMapper modalidadMapper;

    @Test
    public void testFindById_ReturnsModel() {
        ModalidadModel expected = new ModalidadModel();
        expected.setId(1L);
        when(modalidadMapper.findById(1L)).thenReturn(expected);

        ModalidadModel result = modalidadRepositoryImpl.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test(expected = SidepException.class)
    public void testFindById_Exception_ThrowsSidepException() {
        when(modalidadMapper.findById(1L))
                .thenThrow(new DataIntegrityViolationException("Error"));

        modalidadRepositoryImpl.findById(1L);
    }
}
