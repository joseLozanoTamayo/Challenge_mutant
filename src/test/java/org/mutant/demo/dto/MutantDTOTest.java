package org.mutant.demo.dto;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MutantDTOTest {

    @Test
    void mutantDtoTest() {

        String[] arregloString = {"arreglo","string"};
        MutantDTO mutantDTO = new MutantDTO().builder()
                .dna(arregloString)
                .build();

        assertTrue(Objects.nonNull(mutantDTO));
        assertEquals("arreglo", mutantDTO.getDna()[0]);

    }

}