package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.EstablecimientoEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.model.ComunaModel;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.EstablecimientoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EstablecimientoServiceImplTest {

    @InjectMocks
    @Spy
    private EstablecimientoServiceImpl service;

    @Mock
    private EstablecimientoRepository establecimientoRepository;

    private EstablecimientoModel createDummyModel() {
        EstablecimientoModel model = new EstablecimientoModel();
        model.setId(1L);
        model.setFechaCreacion(LocalDateTime.now());
        ComunaModel comuna = new ComunaModel();
        comuna.setId(10L);
        model.setComuna(comuna);
        return model;
    }

    private EstablecimientoEntity createDummyEntity() {
        EstablecimientoEntity entity = new EstablecimientoEntity();
        entity.setId(100L);
        entity.setFechaCreacion(LocalDateTime.now());
        return entity;
    }

    @Test
    public void findAll() {
        List<EstablecimientoModel> expected = Collections.singletonList(createDummyModel());
        when(establecimientoRepository.findAll()).thenReturn(expected);
        List<EstablecimientoModel> result = service.findAll();
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void findById() {
        EstablecimientoModel model = createDummyModel();
        when(establecimientoRepository.findById(anyLong())).thenReturn(model);
        EstablecimientoModel result = service.findById(1L);
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test
    public void save_success() {
        EstablecimientoModel model = createDummyModel();
        when(establecimientoRepository.hasComuna(model.getComuna().getId())).thenReturn(true);

        EstablecimientoEntity entity = createDummyEntity();
        doReturn(entity).when(service).toEntity(model);
        doNothing().when(establecimientoRepository).save(any(EstablecimientoEntity.class));

        EstablecimientoModel result = service.save(model);
        assertNotNull(result);
        assertEquals(Long.valueOf(100L), result.getId());
    }

    @Test(expected = UnidadEducativaException.class)
    public void save_exception_invalidForeignKey() {
        EstablecimientoModel model = createDummyModel();
        when(establecimientoRepository.hasComuna(model.getComuna().getId())).thenReturn(false);
        service.save(model);
    }

    @Test
    public void update_success() {
        EstablecimientoModel model = createDummyModel();
        when(establecimientoRepository.hasComuna(model.getComuna().getId())).thenReturn(true);

        EstablecimientoEntity entity = createDummyEntity();
        doReturn(entity).when(service).toEntity(model);
        doNothing().when(establecimientoRepository).update(anyLong(), any(EstablecimientoEntity.class));

        EstablecimientoModel result = service.update(1L, model);
        assertNotNull(result);
        assertEquals(Long.valueOf(1L), result.getId());
    }
}
