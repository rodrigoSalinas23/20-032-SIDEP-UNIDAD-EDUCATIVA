package cl.mineduc.sidep.unidadeducativaapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UnidadEducativaModel {

    private Long id;
    private CodigoGeograficoModel codigoGeografico;
    private ProgramaModel programa;
    private ModalidadModel modalidad;
    private MecanismoFinanciamientoModel mecanismoFinanciamiento;
    private SostenedorModel sostenedor;
    private EstadoUnidadEducativaModel estadoUnidadEducativa;
    private GeneroModel genero;
    private EstadoFuncionamientoEnsenianzaModel estadoFuncionamientoEnsenianza;
    private String nombre;
    private Long rbd;
    private Integer dvRbd;
    private String codigoAreaTelefono;
    private String telefono;
    private String celular;
    private String mail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaInicioRo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaTerminoRo;

    private String dependencia;
    private String sitioWeb;
    private String softwarePropio;
    private Boolean autorizaIntercambioCorreo;
    private String resolucion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaResolucion;

    private Integer codigoInstitucion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;


}
