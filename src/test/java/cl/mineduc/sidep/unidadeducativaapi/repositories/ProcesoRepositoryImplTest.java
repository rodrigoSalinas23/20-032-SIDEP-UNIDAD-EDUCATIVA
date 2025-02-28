package cl.mineduc.sidep.unidadeducativaapi.repositories;

import cl.mineduc.sidep.unidadeducativaapi.exceptions.SidepException;
import cl.mineduc.sidep.unidadeducativaapi.mappers.ProcesoMapper;
import cl.mineduc.sidep.unidadeducativaapi.utils.ProcesoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ProcesoRepositoryImplTest {

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