package cl.mineduc.sidep.unidadeducativaapi.controller;

import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import cl.mineduc.sidep.unidadeducativaapi.services.UnidadEducativaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadEducativaControllerTest {

    @Mock
    private UnidadEducativaService unidadEducativaService;

    @InjectMocks
    private UnidadEducativaController unidadEducativaController;

    @Test
    public void findAll() {
        List<UnidadEducativaModel> expectedList = Arrays.asList(new UnidadEducativaModel());
        when(unidadEducativaService.findAll()).thenReturn(expectedList);

        ResponseEntity<List<UnidadEducativaModel>> response = unidadEducativaController.findAll();
        assertNotNull(response);
        assertEquals(expectedList, response.getBody());
    }

    @Test
    public void findById() {
        UnidadEducativaModel model = new UnidadEducativaModel();
        model.setId(1L);
        when(unidadEducativaService.findById(1L)).thenReturn(model);

        ResponseEntity<UnidadEducativaModel> response = unidadEducativaController.findById(1L);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void findByRbd() {
        UnidadEducativaModel model = new UnidadEducativaModel();
        model.setId(2L);
        when(unidadEducativaService.findByRbd(123L)).thenReturn(model);

        ResponseEntity<UnidadEducativaModel> response = unidadEducativaController.findByRbd(123L);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void save() {
        UnidadEducativaModel model = new UnidadEducativaModel();
        model.setId(1L);
        when(unidadEducativaService.save(any(UnidadEducativaModel.class))).thenReturn(model);

        ResponseEntity<UnidadEducativaModel> response = unidadEducativaController.save(model);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void update() {
        UnidadEducativaModel model = new UnidadEducativaModel();
        model.setId(1L);
        when(unidadEducativaService.update(eq(1L), any(UnidadEducativaModel.class))).thenReturn(model);

        ResponseEntity<UnidadEducativaModel> response = unidadEducativaController.update(1L, model);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }
}
