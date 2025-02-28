package cl.mineduc.sidep.unidadeducativaapi.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UnidadEducativaModelTest {

    @Test
    public void equalsTest() {
        UnidadEducativaModel model1 = new UnidadEducativaModel();
        UnidadEducativaModel model2 = new UnidadEducativaModel();
        assertEquals(model1, model2);
    }

    @Test
    public void notEqualsTest() {
        UnidadEducativaModel model1 = new UnidadEducativaModel();
        UnidadEducativaModel model2 = new UnidadEducativaModel();
        model1.setId(1L);
        model2.setId(2L);
        assertNotEquals(model1, model2);
    }

    @Test
    public void testHashCode() {
        UnidadEducativaModel model1 = new UnidadEducativaModel();
        UnidadEducativaModel model2 = new UnidadEducativaModel();
        assertEquals(model1.hashCode(), model2.hashCode());
    }

    @Test
    public void testToString() {
        UnidadEducativaModel model = new UnidadEducativaModel();
        String toStringValue = model.toString();
        assertNotNull(toStringValue);
        assertFalse(toStringValue.isEmpty());
    }
}
