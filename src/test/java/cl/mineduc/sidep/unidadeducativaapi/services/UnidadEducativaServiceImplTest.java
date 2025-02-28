package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.entities.UnidadEducativaEntity;
import cl.mineduc.sidep.unidadeducativaapi.exceptions.UnidadEducativaException;
import cl.mineduc.sidep.unidadeducativaapi.model.CodigoGeograficoModel;
import cl.mineduc.sidep.unidadeducativaapi.model.ComunaModel;
import cl.mineduc.sidep.unidadeducativaapi.model.EstadoFuncionamientoEnsenianzaModel;
import cl.mineduc.sidep.unidadeducativaapi.model.EstadoUnidadEducativaModel;
import cl.mineduc.sidep.unidadeducativaapi.model.EstablecimientoModel;
import cl.mineduc.sidep.unidadeducativaapi.model.GeneroModel;
import cl.mineduc.sidep.unidadeducativaapi.model.MecanismoFinanciamientoModel;
import cl.mineduc.sidep.unidadeducativaapi.model.ModalidadModel;
import cl.mineduc.sidep.unidadeducativaapi.model.ProgramaModel;
import cl.mineduc.sidep.unidadeducativaapi.model.SostenedorModel;
import cl.mineduc.sidep.unidadeducativaapi.model.UnidadEducativaModel;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProgramaRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProcesoRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.SostenedorRepository;
import cl.mineduc.sidep.unidadeducativaapi.repositories.UnidadEducativaRepository;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.MyBatisSystemException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UnidadEducativaServiceImplTest {

    @Mock
    private UnidadEducativaRepository unidadEducativaRepository;
    @Mock
    private SostenedorRepository sostenedorRepository;
    @Mock
    private ProcesoRepository procesoRepository;
    @Mock
    private ModalidadService modalidadService;
    @Mock
    private ProgramaRepository programaRepository;

    @InjectMocks
    private UnidadEducativaServiceImpl service;

    private UnidadEducativaModel createValidModel() {
        UnidadEducativaModel model = new UnidadEducativaModel();
        model.setId(1L);
        model.setFechaCreacion(LocalDateTime.now());

        SostenedorModel sostenedor = new SostenedorModel();
        sostenedor.setId(10L);
        model.setSostenedor(sostenedor);

        CodigoGeograficoModel codigo = new CodigoGeograficoModel();
        ComunaModel comuna = new ComunaModel();
        comuna.setId(20L);
        codigo.setComuna(comuna);
        model.setCodigoGeografico(codigo);

        ModalidadModel modalidad = new ModalidadModel();
        modalidad.setId(30L);
        model.setModalidad(modalidad);

        ProgramaModel programa = new ProgramaModel();
        programa.setId(40L);
        model.setPrograma(programa);

        MecanismoFinanciamientoModel mf = new MecanismoFinanciamientoModel();
        mf.setId(50L);
        model.setMecanismoFinanciamiento(mf);

        EstadoUnidadEducativaModel eu = new EstadoUnidadEducativaModel();
        eu.setId(60L);
        model.setEstadoUnidadEducativa(eu);

        GeneroModel genero = new GeneroModel();
        genero.setId(70L);
        model.setGenero(genero);

        EstadoFuncionamientoEnsenianzaModel efe = new EstadoFuncionamientoEnsenianzaModel();
        efe.setId(80L);
        model.setEstadoFuncionamientoEnsenianza(efe);

        return model;
    }

    @Test
    public void findAll_success() {
        List<UnidadEducativaModel> expected = Collections.singletonList(createValidModel());
        when(unidadEducativaRepository.findAll()).thenReturn(expected);
        List<UnidadEducativaModel> result = service.findAll();
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void findById_success() {
        UnidadEducativaModel model = createValidModel();
        when(unidadEducativaRepository.findById(anyLong())).thenReturn(model);
        UnidadEducativaModel result = service.findById(1L);
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test
    public void findByRbd_success() {
        UnidadEducativaModel model = createValidModel();
        when(unidadEducativaRepository.findByRbd(anyLong())).thenReturn(model);
        UnidadEducativaModel result = service.findByRbd(123L);
        assertNotNull(result);
        assertEquals(model, result);
    }

    @Test(expected = UnidadEducativaException.class)
    public void update_notFound_exception() {
        when(unidadEducativaRepository.findByRbd(anyLong())).thenReturn(null);
        UnidadEducativaModel model = createValidModel();
        service.update(123L, model);
    }

    @Test
    public void save_success() {
        UnidadEducativaModel model = createValidModel();
        // Configuramos la validación de claves foráneas:
        when(sostenedorRepository.findById(10L)).thenReturn(model.getSostenedor());
        when(unidadEducativaRepository.hasComuna(20L)).thenReturn(true);
        when(modalidadService.findById(30L)).thenReturn(model.getModalidad());
        when(programaRepository.findById(40L)).thenReturn(model.getPrograma());
        when(unidadEducativaRepository.hasMecanismoFinanciamiento(50L)).thenReturn(true);
        when(unidadEducativaRepository.hasEstadoUnidadEducativa(60L)).thenReturn(true);
        when(unidadEducativaRepository.hasGenero(70L)).thenReturn(true);
        when(unidadEducativaRepository.hasEstadoFuncionamientoEnsenianza(80L)).thenReturn(true);

        doAnswer(invocation -> {
            UnidadEducativaEntity entity = invocation.getArgument(0);
            entity.setId(100L);
            entity.setFechaCreacion(LocalDateTime.now());
            return null;
        }).when(unidadEducativaRepository).save(any(UnidadEducativaEntity.class));

        UnidadEducativaModel result = service.save(model);
        assertNotNull(result);
        assertEquals(Long.valueOf(100L), result.getId());
        assertNotNull(result.getFechaCreacion());
    }

    @Test(expected = UnidadEducativaException.class)
    public void save_invalidSostenedor_exception() {
        UnidadEducativaModel model = createValidModel();
        model.getSostenedor().setId(999L);
        when(sostenedorRepository.findById(999L)).thenReturn(null);
        service.save(model);
    }

    @Test
    public void update_success() {
        UnidadEducativaModel model = createValidModel();
        when(unidadEducativaRepository.findByRbd(anyLong())).thenReturn(createValidModel());
        when(unidadEducativaRepository.hasComuna(anyLong())).thenReturn(true);
        SostenedorModel sostenedor = model.getSostenedor();
        when(sostenedorRepository.findById(sostenedor.getId())).thenReturn(sostenedor);
        ModalidadModel modalidad = model.getModalidad();
        when(modalidadService.findById(modalidad.getId())).thenReturn(modalidad);
        ProgramaModel programa = model.getPrograma();
        when(programaRepository.findById(programa.getId())).thenReturn(programa);
        when(unidadEducativaRepository.hasMecanismoFinanciamiento(model.getMecanismoFinanciamiento().getId())).thenReturn(true);
        when(unidadEducativaRepository.hasEstadoUnidadEducativa(model.getEstadoUnidadEducativa().getId())).thenReturn(true);
        when(unidadEducativaRepository.hasGenero(model.getGenero().getId())).thenReturn(true);
        when(unidadEducativaRepository.hasEstadoFuncionamientoEnsenianza(model.getEstadoFuncionamientoEnsenianza().getId())).thenReturn(true);

        doAnswer(invocation -> {
            UnidadEducativaEntity entity = invocation.getArgument(1);
            entity.setId(123L);
            entity.setFechaActualizacion(LocalDateTime.now());
            return null;
        }).when(unidadEducativaRepository).update(eq(123L), any(UnidadEducativaEntity.class));

        UnidadEducativaModel result = service.update(123L, model);
        assertNotNull(result);
        assertEquals(Long.valueOf(123L), result.getId());
        assertNotNull(result.getFechaActualizacion());
    }

    @Test(expected = UnidadEducativaException.class)
    public void update_invalidModalidad_exception() {
        UnidadEducativaModel model = createValidModel();
        model.getModalidad().setId(999L);

        when(unidadEducativaRepository.findByRbd(anyLong())).thenReturn(model);
        lenient().when(modalidadService.findById(999L)).thenReturn(null);

        service.update(123L, model);
    }
}
