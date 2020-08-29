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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class StatsDTOTest {

    @Test
    void statsDtoTest() {

        StatsDTO statsDto = new StatsDTO().builder()
                .countHumanDna(Long.valueOf(2))
                .ratio(Double.valueOf(2.0))
                .countMutantDna(Long.valueOf(1))
                .build();

        assertTrue(Objects.nonNull(statsDto));
        assertEquals(Long.valueOf(2), statsDto.getCountHumanDna());
        assertEquals(Long.valueOf(1
        ), statsDto.getCountMutantDna());
    }

}