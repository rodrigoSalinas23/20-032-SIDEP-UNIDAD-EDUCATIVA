package cl.mineduc.sidep.unidadeducativaapi.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EstablecimientoModelTest {

    @Test
    public void equalsTest() {
        EstablecimientoModel model1 = new EstablecimientoModel();
        EstablecimientoModel model2 = new EstablecimientoModel();
        assertEquals(model1, model2);
    }

    @Test
    public void notEqualsTest() {
        EstablecimientoModel model1 = new EstablecimientoModel();
        EstablecimientoModel model2 = new EstablecimientoModel();
        model1.setId(1L);
        model2.setId(2L);
        assertNotEquals(model1, model2);
    }

    @Test
    public void testHashCode() {
        EstablecimientoModel model1 = new EstablecimientoModel();
        EstablecimientoModel model2 = new EstablecimientoModel();
        assertEquals(model1.hashCode(), model2.hashCode());
    }

    @Test
    public void testToString() {
        EstablecimientoModel model = new EstablecimientoModel();
        String toStringValue = model.toString();
        assertNotNull(toStringValue);
        assertFalse(toStringValue.isEmpty());
    }
}
