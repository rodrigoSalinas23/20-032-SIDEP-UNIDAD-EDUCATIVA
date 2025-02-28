package cl.mineduc.sidep.unidadeducativaapi.entities;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FichaEstablecimientoEntityTest {

    @Test
    public void equalsTest() {
        FichaEstablecimientoEntity e1 = new FichaEstablecimientoEntity();
        FichaEstablecimientoEntity e2 = new FichaEstablecimientoEntity();
        assertEquals(e1, e2);
    }

    @Test
    public void notEqualsTest() {
        FichaEstablecimientoEntity e1 = new FichaEstablecimientoEntity();
        FichaEstablecimientoEntity e2 = new FichaEstablecimientoEntity();
        e1.setId(1L);
        e2.setId(2L);
        assertNotEquals(e1, e2);
    }

    @Test
    public void testHashCode() {
        FichaEstablecimientoEntity e1 = new FichaEstablecimientoEntity();
        FichaEstablecimientoEntity e2 = new FichaEstablecimientoEntity();
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testToString() {
        FichaEstablecimientoEntity e1 = new FichaEstablecimientoEntity();
        String toStringValue = e1.toString();
        assertNotEquals("", toStringValue);
    }
}
