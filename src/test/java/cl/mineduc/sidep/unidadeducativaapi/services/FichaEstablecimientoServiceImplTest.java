package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.FichaEstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.FichaEstablecimientoRepository;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class TestFichaEstablecimientoServiceImpl extends FichaEstablecimientoServiceImpl {
    public TestFichaEstablecimientoServiceImpl(FichaEstablecimientoRepository repo) {
        super(repo);
    }

    @Override
    public FichaEstablecimientoEntity toEntity(FichaEstablecimientoModel model) {
        FichaEstablecimientoEntity entity = new FichaEstablecimientoEntity();
        entity.setId(model.getId() == null ? 100L : model.getId());
        entity.setFechaCreacion(model.getFechaCreacion() == null ? LocalDateTime.now() : model.getFechaCreacion());
        entity.setFechaActualizacion(LocalDateTime.now());
        return entity;
    }
}

@RunWith(MockitoJUnitRunner.class)
public class FichaEstablecimientoServiceImplTest {

    @Mock
    private FichaEstablecimientoRepository fichaEstablecimientoRepository;

    private FichaEstablecimientoServiceImpl service;

    @Before
    public void setUp() {
        service = new TestFichaEstablecimientoServiceImpl(fichaEstablecimientoRepository);
    }

    private FichaEstablecimientoModel createDummyModel() {
        FichaEstablecimientoModel model = new FichaEstablecimientoModel();
        model.setId(1L);
        model.setFechaCreacion(LocalDateTime.now());
        EstablecimientoModel est = new EstablecimientoModel();
        est.setId(10L);
        model.setEstablecimiento(est);
        return model;
    }

    @Test
    public void findAll() {
        List<FichaEstablecimientoModel> expected = Collections.singletonList(createDummyModel());
        when(fichaEstablecimientoRepository.findAll()).thenReturn(expected);
        List<FichaEstablecimientoModel> result = service.findAll();
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test(expected = MyBatisSystemException.class)
    public void findAll_exception() {
        when(fichaEstablecimientoRepository.findAll())
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        service.findAll();
    }

    @Test
    public void findById() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.findById(anyLong())).thenReturn(model);
        FichaEstablecimientoModel result = service.findById(1L);
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test(expected = MyBatisSystemException.class)
    public void findById_exception() {
        when(fichaEstablecimientoRepository.findById(anyLong()))
                .thenThrow(new MyBatisSystemException(new PersistenceException("Error")));
        service.findById(1L);
    }

    @Test
    public void save_success() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.hasEstablecimiento(model.getEstablecimiento().getId())).thenReturn(true);

        doAnswer(invocation -> {
            FichaEstablecimientoEntity entity = invocation.getArgument(0);
            entity.setId(100L);
            entity.setFechaCreacion(LocalDateTime.now());
            return null;
        }).when(fichaEstablecimientoRepository).save(any(FichaEstablecimientoEntity.class));

        FichaEstablecimientoModel result = service.save(model);
        assertNotNull(result);
        assertEquals(Long.valueOf(100L), result.getId());
        assertNotNull(result.getFechaCreacion());
    }

    @Test(expected = UnidadEducativaException.class)
    public void save_invalidForeignKey_exception() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.hasEstablecimiento(model.getEstablecimiento().getId())).thenReturn(false);
        service.save(model);
    }

    @Test(expected = MyBatisSystemException.class)
    public void save_exception() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.hasEstablecimiento(model.getEstablecimiento().getId())).thenReturn(true);
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(fichaEstablecimientoRepository).save(any(FichaEstablecimientoEntity.class));
        service.save(model);
    }

    @Test
    public void update_success() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.hasEstablecimiento(model.getEstablecimiento().getId())).thenReturn(true);
        doNothing().when(fichaEstablecimientoRepository).update(eq(1L), any(FichaEstablecimientoEntity.class));

        FichaEstablecimientoModel result = service.update(1L, model);
        assertNotNull(result);
        assertEquals(Long.valueOf(1L), result.getId());
        assertNotNull(result.getFechaActualizacion());
    }

    @Test(expected = UnidadEducativaException.class)
    public void update_invalidForeignKey_exception() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.hasEstablecimiento(model.getEstablecimiento().getId())).thenReturn(false);
        service.update(1L, model);
    }

    @Test(expected = MyBatisSystemException.class)
    public void update_exception() {
        FichaEstablecimientoModel model = createDummyModel();
        when(fichaEstablecimientoRepository.hasEstablecimiento(model.getEstablecimiento().getId())).thenReturn(true);
        doThrow(new MyBatisSystemException(new PersistenceException("Error")))
                .when(fichaEstablecimientoRepository).update(eq(1L), any(FichaEstablecimientoEntity.class));
        service.update(1L, model);
    }
}
