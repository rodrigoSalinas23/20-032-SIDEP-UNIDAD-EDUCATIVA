package cl.mineduc.sidep.unidadeducativaapi.entities;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EstablecimientoEntityTest {

    @Test
    public void equalsTest() {
        EstablecimientoEntity e1 = new EstablecimientoEntity();
        EstablecimientoEntity e2 = new EstablecimientoEntity();
        assertEquals(e1, e2);
    }

    @Test
    public void notEqualsTest() {
        EstablecimientoEntity e1 = new EstablecimientoEntity();
        EstablecimientoEntity e2 = new EstablecimientoEntity();
        e1.setId(1L);
        e2.setId(2L);
        assertNotEquals(e1, e2);
    }

    @Test
    public void testHashCode() {
        EstablecimientoEntity e1 = new EstablecimientoEntity();
        EstablecimientoEntity e2 = new EstablecimientoEntity();
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testToString() {
        EstablecimientoEntity e1 = new EstablecimientoEntity();
        String toStringValue = e1.toString();
        assertNotEquals("", toStringValue);
    }
}
