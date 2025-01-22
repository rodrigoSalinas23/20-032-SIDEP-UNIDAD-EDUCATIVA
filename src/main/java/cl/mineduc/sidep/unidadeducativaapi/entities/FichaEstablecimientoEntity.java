package cl.mineduc.sidep.unidadeducativaapi.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FichaEstablecimientoEntity {

    private Long id;
    private Long establecimiento;
    private Integer superficieTerrenoM2;
    private Integer superficieEdificadaM2;
    private Integer numeroSalas;
    private Integer capacidadSala;
    private Integer capacidadNivel;
    private Boolean ruralidad;
    private Integer numeroPisos;
    private Integer rolSii;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}
