package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.UnidadEducativaMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadEducativaRepositoryImplTest {

    @InjectMocks
    private UnidadEducativaRepositoryImpl unidadEducativaRepositoryImpl;

    @Mock
    private UnidadEducativaMapper unidadEducativaMapper;

    @Test
    public void testFindAll_ReturnsList() {
        List<UnidadEducativaModel> expectedList = Collections.singletonList(new UnidadEducativaModel());
        when(unidadEducativaMapper.findAll()).thenReturn(expectedList);

        List<UnidadEducativaModel> result = unidadEducativaRepositoryImpl.findAll();
        assertNotNull(result);
        assertEquals(expectedList, result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testFindAll_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.findAll()).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.findAll();
    }

    @Test
    public void testFindById_ReturnsModel() {
        UnidadEducativaModel expected = new UnidadEducativaModel();
        expected.setId(1L);
        when(unidadEducativaMapper.findById(1L)).thenReturn(expected);

        UnidadEducativaModel result = unidadEducativaRepositoryImpl.findById(1L);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testFindById_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.findById(1L)).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.findById(1L);
    }

    @Test
    public void testFindByRbd_ReturnsModel() {
        UnidadEducativaModel expected = new UnidadEducativaModel();
        expected.setId(2L);
        when(unidadEducativaMapper.findByRbd(123L)).thenReturn(expected);

        UnidadEducativaModel result = unidadEducativaRepositoryImpl.findByRbd(123L);
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testFindByRbd_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.findByRbd(123L)).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.findByRbd(123L);
    }

    @Test
    public void testSave_Success() {
        UnidadEducativaEntity entity = new UnidadEducativaEntity();
        doNothing().when(unidadEducativaMapper).insert(entity);

        unidadEducativaRepositoryImpl.save(entity);
        verify(unidadEducativaMapper, times(1)).insert(entity);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testSave_Exception_ThrowsUnidadEducativaException() {
        UnidadEducativaEntity entity = new UnidadEducativaEntity();
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(unidadEducativaMapper).insert(entity);

        unidadEducativaRepositoryImpl.save(entity);
    }

    @Test
    public void testUpdate_Success() {
        UnidadEducativaEntity entity = new UnidadEducativaEntity();
        doNothing().when(unidadEducativaMapper).update(123L, entity);

        unidadEducativaRepositoryImpl.update(123L, entity);
        verify(unidadEducativaMapper, times(1)).update(123L, entity);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testUpdate_Exception_ThrowsUnidadEducativaException() {
        UnidadEducativaEntity entity = new UnidadEducativaEntity();
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(unidadEducativaMapper).update(123L, entity);

        unidadEducativaRepositoryImpl.update(123L, entity);
    }

    @Test
    public void testHasMecanismoFinanciamiento_ReturnsTrue() {
        when(unidadEducativaMapper.hasMecanismoFinanciamiento(1L)).thenReturn(true);
        Boolean result = unidadEducativaRepositoryImpl.hasMecanismoFinanciamiento(1L);
        assertTrue(result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testHasMecanismoFinanciamiento_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.hasMecanismoFinanciamiento(1L))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.hasMecanismoFinanciamiento(1L);
    }

    @Test
    public void testHasEstadoUnidadEducativa_ReturnsTrue() {
        when(unidadEducativaMapper.hasEstadoUnidadEducativa(1L)).thenReturn(true);
        Boolean result = unidadEducativaRepositoryImpl.hasEstadoUnidadEducativa(1L);
        assertTrue(result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testHasEstadoUnidadEducativa_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.hasEstadoUnidadEducativa(1L))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.hasEstadoUnidadEducativa(1L);
    }

    @Test
    public void testHasGenero_ReturnsTrue() {
        when(unidadEducativaMapper.hasGenero(1L)).thenReturn(true);
        Boolean result = unidadEducativaRepositoryImpl.hasGenero(1L);
        assertTrue(result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testHasGenero_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.hasGenero(1L))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.hasGenero(1L);
    }

    @Test
    public void testHasEstadoFuncionamientoEnsenianza_ReturnsTrue() {
        when(unidadEducativaMapper.hasEstadoFuncionamientoEnsenianza(1L)).thenReturn(true);
        Boolean result = unidadEducativaRepositoryImpl.hasEstadoFuncionamientoEnsenianza(1L);
        assertTrue(result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testHasEstadoFuncionamientoEnsenianza_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.hasEstadoFuncionamientoEnsenianza(1L))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.hasEstadoFuncionamientoEnsenianza(1L);
    }

    @Test
    public void testHasComuna_ReturnsTrue() {
        when(unidadEducativaMapper.hasComuna(1L)).thenReturn(true);
        Boolean result = unidadEducativaRepositoryImpl.hasComuna(1L);
        assertTrue(result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testHasComuna_Exception_ThrowsUnidadEducativaException() {
        when(unidadEducativaMapper.hasComuna(1L))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        unidadEducativaRepositoryImpl.hasComuna(1L);
    }
}
