package cl.mineduc.sidep.unidadeducativaapi.entities;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UnidadEducativaEntity {

    private Long id;
    private Long programa;
    private Long modalidad;
    private Long comuna;
    private Long mecanismoFinanciamiento;
    private Long sostenedor;
    private Long estadoUnidadEducativa;
    private Long genero;
    private Long estadoFuncionamientoEnsenianza;
    private String nombre;
    private Long rbd;
    private Integer dvRbd;
    private String codigoAreaTelefono;
    private String telefono;
    private String celular;
    private String mail;
    private LocalDate fechaInicioRo;
    private LocalDate fechaTerminoRo;
    private String dependencia;
    private String sitioWeb;
    private String softwarePropio;
    private Boolean autorizaIntercambioCorreo;
    private String resolucion;
    private LocalDate fechaResolucion;
    private Integer codigoInstitucion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}
