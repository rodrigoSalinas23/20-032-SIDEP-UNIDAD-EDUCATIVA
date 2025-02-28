package cl.mineduc.sidep.unidadeducativaapi.entities;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class UnidadEducativaEntityTest {

    @Test
    public void equalsTest() {
        UnidadEducativaEntity e1 = new UnidadEducativaEntity();
        UnidadEducativaEntity e2 = new UnidadEducativaEntity();
        assertEquals(e1, e2);
    }

    @Test
    public void notEqualsTest() {
        UnidadEducativaEntity e1 = new UnidadEducativaEntity();
        UnidadEducativaEntity e2 = new UnidadEducativaEntity();
        e1.setId(1L);
        e2.setId(2L);
        assertNotEquals(e1, e2);
    }

    @Test
    public void testHashCode() {
        UnidadEducativaEntity e1 = new UnidadEducativaEntity();
        UnidadEducativaEntity e2 = new UnidadEducativaEntity();
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testToString() {
        UnidadEducativaEntity e1 = new UnidadEducativaEntity();
        e1.setId(1L);
        e1.setNombre("TEST");
        e1.setRbd(12345L);
        e1.setFechaCreacion(LocalDateTime.now());
        e1.setFechaInicioRo(LocalDate.now());
        String toStringValue = e1.toString();
        assertNotNull(toStringValue);
        assertFalse(toStringValue.isEmpty());
    }
}
