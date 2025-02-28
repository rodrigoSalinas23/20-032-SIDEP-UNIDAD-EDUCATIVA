package cl.mineduc.sidep.unidadeducativaapi.controller;

import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.services.EstablecimientoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EstablecimientoControllerTest {

    @Mock
    private EstablecimientoService establecimientoService;

    @InjectMocks
    private EstablecimientoController establecimientoController;

    @Test
    public void findAll() {
        List<EstablecimientoModel> expectedList = Arrays.asList(new EstablecimientoModel());
        when(establecimientoService.findAll()).thenReturn(expectedList);

        ResponseEntity<List<EstablecimientoModel>> response = establecimientoController.findAll();
        assertNotNull(response);
        assertEquals(expectedList, response.getBody());
    }

    @Test
    public void findById() {
        EstablecimientoModel model = new EstablecimientoModel();
        model.setId(1L);
        when(establecimientoService.findById(1L)).thenReturn(model);

        ResponseEntity<EstablecimientoModel> response = establecimientoController.findById(1L);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void save() {
        EstablecimientoModel model = new EstablecimientoModel();
        model.setId(1L);
        when(establecimientoService.save(any(EstablecimientoModel.class))).thenReturn(model);

        ResponseEntity<EstablecimientoModel> response = establecimientoController.save(model);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }

    @Test
    public void update() {
        EstablecimientoModel model = new EstablecimientoModel();
        model.setId(1L);
        when(establecimientoService.update(eq(1L), any(EstablecimientoModel.class))).thenReturn(model);

        ResponseEntity<EstablecimientoModel> response = establecimientoController.update(1L, model);
        assertNotNull(response);
        assertEquals(model, response.getBody());
    }
}
