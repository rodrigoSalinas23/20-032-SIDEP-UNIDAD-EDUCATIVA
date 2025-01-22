package cl.mineduc.sidep.unidadeducativaapi.utils;

import cl.mineduc.sidep.unidadeducativaapi.entities.ProcesoEntity;

public class ProcesoUtils {

    private ProcesoUtils() {
        super();
    }

    public static String getOperacion(String method, String uri) {
        return String.format("%s - %s", method, uri);
    }

    public static ProcesoEntity getProcesoEntity(Integer status, String operacion, String mensaje) {
        return ProcesoEntity
                .builder()
                .status(status)
                .mensaje(mensaje)
                .operacion(operacion).build();
    }

}
