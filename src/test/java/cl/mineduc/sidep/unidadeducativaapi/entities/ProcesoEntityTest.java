package cl.mineduc.sidep.unidadeducativaapi.entities;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProcesoEntityTest {

    @Test
    public void equalsTest() {
        ProcesoEntity e1 = ProcesoEntity.builder()
                .operacion("OPERACION")
                .status(200)
                .mensaje("OK")
                .build();
        ProcesoEntity e2 = ProcesoEntity.builder()
                .operacion("OPERACION")
                .status(200)
                .mensaje("OK")
                .build();
        assertEquals(e1, e2);
    }

    @Test
    public void notEqualsTest() {
        ProcesoEntity e1 = ProcesoEntity.builder()
                .operacion("OPERACION1")
                .status(200)
                .mensaje("OK")
                .build();
        ProcesoEntity e2 = ProcesoEntity.builder()
                .operacion("OPERACION2")
                .status(200)
                .mensaje("OK")
                .build();
        assertNotEquals(e1, e2);
    }

    @Test
    public void testHashCode() {
        ProcesoEntity e1 = ProcesoEntity.builder()
                .operacion("OPERACION")
                .status(200)
                .mensaje("OK")
                .build();
        ProcesoEntity e2 = ProcesoEntity.builder()
                .operacion("OPERACION")
                .status(200)
                .mensaje("OK")
                .build();
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testToString() {
        ProcesoEntity e1 = ProcesoEntity.builder()
                .operacion("OPERACION")
                .status(200)
                .mensaje("OK")
                .build();
        String toStringValue = e1.toString();
        assertNotNull(toStringValue);
        assertFalse(toStringValue.isEmpty());
    }
}
