package cl.mineduc.sidep.unidadeducativaapi.config;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpringFoxConfigTest {

    SpringFoxConfig springFoxConfig = new SpringFoxConfig();

    @Test
    public void docket() {
        assertNotNull(springFoxConfig.docket());
    }


}