package cl.mineduc.sidep.unidadeducativaapi.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SostenedorModelTest {

    @Test
    public void equalsTest() {
        SostenedorModel model1 = new SostenedorModel();
        SostenedorModel model2 = new SostenedorModel();
        assertEquals(model1, model2);
    }

    @Test
    public void notEqualsTest() {
        SostenedorModel model1 = new SostenedorModel();
        SostenedorModel model2 = new SostenedorModel();
        model1.setId(1L);
        model2.setId(2L);
        assertNotEquals(model1, model2);
    }

    @Test
    public void testHashCode() {
        SostenedorModel model1 = new SostenedorModel();
        SostenedorModel model2 = new SostenedorModel();
        assertEquals(model1.hashCode(), model2.hashCode());
    }

    @Test
    public void testToString() {
        SostenedorModel model = new SostenedorModel();
        String toStringValue = model.toString();
        assertNotNull(toStringValue);
        assertFalse(toStringValue.isEmpty());
    }
}
