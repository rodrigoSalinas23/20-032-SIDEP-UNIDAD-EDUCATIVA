package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.EstablecimientoMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
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
public class EstablecimientoRepositoryImplTest {

    @InjectMocks
    private EstablecimientoRepositoryImpl establecimientoRepositoryImpl;

    @Mock
    private EstablecimientoMapper establecimientoMapper;

    @Test
    public void testFindAll_ReturnsList() {
        List<EstablecimientoModel> expectedList = Collections.singletonList(new EstablecimientoModel());
        when(establecimientoMapper.findAll()).thenReturn(expectedList);

        List<EstablecimientoModel> result = establecimientoRepositoryImpl.findAll();
        assertNotNull(result);
        assertEquals(expectedList, result);
    }

    @Test(expected = SidepException.class)
    public void testFindAll_Exception_ThrowsSidepException() {
        when(establecimientoMapper.findAll()).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        establecimientoRepositoryImpl.findAll();
    }

    @Test
    public void testFindById_ReturnsModel() {
        EstablecimientoModel model = new EstablecimientoModel();
        when(establecimientoMapper.findById(1L)).thenReturn(model);

        EstablecimientoModel result = establecimientoRepositoryImpl.findById(1L);
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test(expected = SidepException.class)
    public void testFindById_Exception_ThrowsSidepException() {
        when(establecimientoMapper.findById(1L)).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        establecimientoRepositoryImpl.findById(1L);
    }

    @Test
    public void testSave_Success() {
        EstablecimientoEntity entity = new EstablecimientoEntity();
        doNothing().when(establecimientoMapper).insert(entity);

        establecimientoRepositoryImpl.save(entity);
        verify(establecimientoMapper, times(1)).insert(entity);
    }

    @Test(expected = SidepException.class)
    public void testSave_Exception_ThrowsSidepException() {
        EstablecimientoEntity entity = new EstablecimientoEntity();
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(establecimientoMapper).insert(entity);

        establecimientoRepositoryImpl.save(entity);
    }

    @Test
    public void testUpdate_Success() {
        EstablecimientoEntity entity = new EstablecimientoEntity();
        doNothing().when(establecimientoMapper).update(1L, entity);

        establecimientoRepositoryImpl.update(1L, entity);
        verify(establecimientoMapper, times(1)).update(1L, entity);
    }

    @Test(expected = SidepException.class)
    public void testUpdate_Exception_ThrowsSidepException() {
        EstablecimientoEntity entity = new EstablecimientoEntity();
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(establecimientoMapper).update(1L, entity);

        establecimientoRepositoryImpl.update(1L, entity);
    }

    @Test
    public void testHasComuna_ReturnsTrue() {
        when(establecimientoMapper.hasComuna(1L)).thenReturn(true);
        Boolean result = establecimientoRepositoryImpl.hasComuna(1L);
        assertTrue(result);
    }

    @Test(expected = SidepException.class)
    public void testHasComuna_Exception_ThrowsSidepException() {
        when(establecimientoMapper.hasComuna(1L)).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        establecimientoRepositoryImpl.hasComuna(1L);
    }
}
