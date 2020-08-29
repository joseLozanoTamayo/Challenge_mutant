package org.mutant.demo.dto;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mutant.demo.enums.CircuitEnum;
import org.mutant.demo.enums.MutantProcessInitEnum;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MutantProcessVarDTOTest {

    @Test
    void mutantProcessVarDtoTest() {

        String[] arreglo = {"arreglo", "string"};
        MutantProcessVarDTO mutantProcessVarDTO = new MutantProcessVarDTO().builder()
                .arrayMutant(arreglo)
                .arrayMutantSize(arreglo.length)
                .circuitEnum(CircuitEnum.DAG_DOWN)
                .colStart(2)
                .column(2)
                .mutantProcessInitEnum(MutantProcessInitEnum.BOTTOM)
                .row(2)
                .rowStart(1)
                .build();

        assertTrue(Objects.nonNull(mutantProcessVarDTO));
        assertEquals("arreglo", mutantProcessVarDTO.getArrayMutant()[0]);
        assertEquals(Integer.valueOf(2), mutantProcessVarDTO.getArrayMutantSize());
        assertEquals(CircuitEnum.DAG_DOWN, mutantProcessVarDTO.getCircuitEnum());
        assertEquals(Integer.valueOf(2), mutantProcessVarDTO.getColStart());
        assertEquals(Integer.valueOf(2), mutantProcessVarDTO.getColumn());
        assertEquals(MutantProcessInitEnum.BOTTOM, mutantProcessVarDTO.getMutantProcessInitEnum());
        assertEquals(Integer.valueOf(2), mutantProcessVarDTO.getRow());
        assertEquals(Integer.valueOf(1), mutantProcessVarDTO.getRowStart());

    }


}