package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.mappers.SostenedorMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.SostenedorModel;
import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SostenedorRepositoryImplTest {

    @InjectMocks
    private SostenedorRepositoryImpl sostenedorRepositoryImpl;

    @Mock
    private SostenedorMapper sostenedorMapper;

    @Test
    public void testFindById_ReturnsModel() {
        SostenedorModel expected = new SostenedorModel();
        expected.setId(1L);
        when(sostenedorMapper.findById(1L)).thenReturn(expected);

        SostenedorModel result = sostenedorRepositoryImpl.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void testFindById_Exception_ReturnsNull() {
        when(sostenedorMapper.findById(1L)).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        SostenedorModel result = sostenedorRepositoryImpl.findById(1L);
        assertNull(result);
    }
}
