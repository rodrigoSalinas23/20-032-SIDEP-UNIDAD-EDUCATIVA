package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.FichaEstablecimientoMapper;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
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
public class FichaEstablecimientoRepositoryImplTest {

    @InjectMocks
    private FichaEstablecimientoRepositoryImpl fichaEstablecimientoRepositoryImpl;

    @Mock
    private FichaEstablecimientoMapper fichaEstablecimientoMapper;

    @Test
    public void testFindAll_ReturnsList() {
        List<FichaEstablecimientoModel> expectedList = Collections.singletonList(new FichaEstablecimientoModel());
        when(fichaEstablecimientoMapper.findAll()).thenReturn(expectedList);

        List<FichaEstablecimientoModel> result = fichaEstablecimientoRepositoryImpl.findAll();
        assertNotNull(result);
        assertEquals(expectedList, result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testFindAll_Exception_ThrowsUnidadEducativaException() {
        when(fichaEstablecimientoMapper.findAll()).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        fichaEstablecimientoRepositoryImpl.findAll();
    }

    @Test
    public void testFindById_ReturnsModel() {
        FichaEstablecimientoModel model = new FichaEstablecimientoModel();
        when(fichaEstablecimientoMapper.findById(1L)).thenReturn(model);

        FichaEstablecimientoModel result = fichaEstablecimientoRepositoryImpl.findById(1L);
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testFindById_Exception_ThrowsUnidadEducativaException() {
        when(fichaEstablecimientoMapper.findById(1L)).thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        fichaEstablecimientoRepositoryImpl.findById(1L);
    }

    @Test
    public void testSave_Success() {
        FichaEstablecimientoEntity entity = new FichaEstablecimientoEntity();
        doNothing().when(fichaEstablecimientoMapper).insert(entity);

        fichaEstablecimientoRepositoryImpl.save(entity);
        verify(fichaEstablecimientoMapper, times(1)).insert(entity);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testSave_Exception_ThrowsUnidadEducativaException() {
        FichaEstablecimientoEntity entity = new FichaEstablecimientoEntity();
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(fichaEstablecimientoMapper).insert(entity);

        fichaEstablecimientoRepositoryImpl.save(entity);
    }

    @Test
    public void testUpdate_Success() {
        FichaEstablecimientoEntity entity = new FichaEstablecimientoEntity();
        doNothing().when(fichaEstablecimientoMapper).update(1L, entity);

        fichaEstablecimientoRepositoryImpl.update(1L, entity);
        verify(fichaEstablecimientoMapper, times(1)).update(1L, entity);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testUpdate_Exception_ThrowsUnidadEducativaException() {
        FichaEstablecimientoEntity entity = new FichaEstablecimientoEntity();
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(fichaEstablecimientoMapper).update(1L, entity);

        fichaEstablecimientoRepositoryImpl.update(1L, entity);
    }

    @Test
    public void testHasEstablecimiento_ReturnsTrue() {
        when(fichaEstablecimientoMapper.hasEstablecimiento(1L)).thenReturn(true);
        Boolean result = fichaEstablecimientoRepositoryImpl.hasEstablecimiento(1L);
        assertTrue(result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void testHasEstablecimiento_Exception_ThrowsUnidadEducativaException() {
        when(fichaEstablecimientoMapper.hasEstablecimiento(1L))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        fichaEstablecimientoRepositoryImpl.hasEstablecimiento(1L);
    }
}
