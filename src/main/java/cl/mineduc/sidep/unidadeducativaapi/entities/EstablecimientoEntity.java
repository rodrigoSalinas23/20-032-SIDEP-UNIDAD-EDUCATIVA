package cl.mineduc.sidep.unidadeducativaapi.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EstablecimientoEntity {

    private Long id;
    private Long comuna;
    private String direccion;
    private String direccionNumero;
    private String direccionReferencia;
    private String codigoPostal;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Integer tipologia;
    private Integer modalidadAtencion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}
