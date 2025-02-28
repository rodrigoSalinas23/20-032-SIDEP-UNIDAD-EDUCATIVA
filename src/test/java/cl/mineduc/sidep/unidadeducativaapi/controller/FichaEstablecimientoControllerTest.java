package cl.mineduc.sidep.unidadeducativaapi.controller;

import cl.mineduc.sidep.unidadeducativaapi.model.FichaEstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.services.FichaEstablecimientoService;
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
public class FichaEstablecimientoControllerTest {

    @Mock
    private FichaEstablecimientoService fichaEstablecimientoService;

    @InjectMocks
    private FichaEstablecimientoController fichaEstablecimientoController;

    @Test
    public void findAll() {
        List<FichaEstablecimientoModel> expectedList = Arrays.asList(new FichaEstablecimientoModel());
        when(fichaEstablecimientoService.findAll()).thenReturn(expectedList);

        ResponseEntity<List<FichaEstablecimientoModel>> response = fichaEstablecimientoController.findAll();
        assertNotNull(response);
        assertEquals(expectedList, response.getBody());
    }

    @Test
    public void findById() {
        FichaEstablecimientoModel model = new FichaEstablecimientoModel();
        model.setId(1L);
        when(fichaEstablecimientoService.findById(1L)).thenReturn(model);

        ResponseEntity<FichaEstablecimientoModel> response = fichaEstablecimientoController.findById(1L);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void save() {
        FichaEstablecimientoModel model = new FichaEstablecimientoModel();
        model.setId(1L);
        when(fichaEstablecimientoService.save(any(FichaEstablecimientoModel.class))).thenReturn(model);

        ResponseEntity<FichaEstablecimientoModel> response = fichaEstablecimientoController.save(model);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void update() {
        FichaEstablecimientoModel model = new FichaEstablecimientoModel();
        model.setId(1L);
        when(fichaEstablecimientoService.update(eq(1L), any(FichaEstablecimientoModel.class))).thenReturn(model);

        ResponseEntity<FichaEstablecimientoModel> response = fichaEstablecimientoController.update(1L, model);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }
}
