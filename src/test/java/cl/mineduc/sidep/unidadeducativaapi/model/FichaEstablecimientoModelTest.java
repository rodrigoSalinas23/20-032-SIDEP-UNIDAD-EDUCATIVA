package cl.mineduc.sidep.unidadeducativaapi.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FichaEstablecimientoModelTest {

    @Test
    public void equalsTest() {
        FichaEstablecimientoModel model1 = new FichaEstablecimientoModel();
        FichaEstablecimientoModel model2 = new FichaEstablecimientoModel();
        assertEquals(model1, model2);
    }

    @Test
    public void notEqualsTest() {
        FichaEstablecimientoModel model1 = new FichaEstablecimientoModel();
        FichaEstablecimientoModel model2 = new FichaEstablecimientoModel();
        model1.setId(1L);
        model2.setId(2L);
        assertNotEquals(model1, model2);
    }

    @Test
    public void testHashCode() {
        FichaEstablecimientoModel model1 = new FichaEstablecimientoModel();
        FichaEstablecimientoModel model2 = new FichaEstablecimientoModel();
        assertEquals(model1.hashCode(), model2.hashCode());
    }

    @Test
    public void testToString() {
        FichaEstablecimientoModel model = new FichaEstablecimientoModel();
        String toStringValue = model.toString();
        assertNotNull(toStringValue);
        assertFalse(toStringValue.isEmpty());
    }
}
