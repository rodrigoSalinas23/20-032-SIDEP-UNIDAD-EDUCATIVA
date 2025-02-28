package cl.mineduc.sidep.unidadeducativaapi.services;

import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ProcesoMapper;
import cl.mineduc.sidep.unidadeducativaapi.repositories.ProcesoRepositoryImpl;
import cl.mineduc.sidep.unidadeducativaapi.utils.ProcesoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mybatis.spring.MyBatisSystemException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProcesoServiceImplTest {

    @InjectMocks
    private ProcesoRepositoryImpl procesoRepository;

    @Mock
    private ProcesoMapper procesoMapper;

    @Test
    public void save() {
        doNothing().when(procesoMapper).insert(any());
        this.procesoRepository.save(ProcesoUtils.getProcesoEntity(200, "test", "test"));
        verify(procesoMapper).insert(any());
    }

    @Test(expected = SidepException.class)
    public void save_exception() {
        doThrow(MyBatisSystemException.class).when(procesoMapper).insert(any());
        this.procesoRepository.save(ProcesoUtils.getProcesoEntity(200, "test", "test"));
    }

}