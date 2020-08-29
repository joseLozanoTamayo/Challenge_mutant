package org.mutant.demo.service;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mutant.demo.dto.StatsDTO;
import org.mutant.demo.model.entities.MutantEntity;
import org.mutant.demo.repository.MutantRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MutantServiceImplTest {


    @Mock
    private MutantRepository mutantRepository;

    @InjectMocks
    MutantServiceImpl mutantServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(mutantRepository.save(Mockito.any(MutantEntity.class))).thenReturn(MutantEntity.builder()
                .id(String.join("1"))
                .isMutantValue(true)
                .build());
    }

    @Test
    void isMutantTest() {

        String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        boolean flag = mutantServiceImpl.mutant(dna);
        assertTrue(flag);

    }

    @Test
    void isNotMutantTest() {

        String[] dna = {"ATGAGA","CAGAGC","TTCTGT","AGAAGG","CTTCTA","TCACTG"};

        boolean flag = mutantServiceImpl.mutant(dna);

        assertFalse(flag);

    }


    @Test
    void validateRatioReturnZeroTest() {
        double response = mutantServiceImpl.validateRatio(Long.parseLong("2"), Long.valueOf(2));
        assertTrue(response > 0L);
        assertTrue(response == 1L);

    }

    @Test
    void validateRatioReturnRatioMutantTest() {
        double response = mutantServiceImpl.validateRatio(Long.parseLong("2"), Long.valueOf(20));
        System.out.println(" response : " + response);
        assertTrue(response > 0L);
        assertTrue(response == 0.1D);
    }


    @Test
    void validateRatioReturnRatioHumanTest() {

        double response = mutantServiceImpl.validateRatio(Long.parseLong("40"), Long.valueOf(20));
        System.out.println(" response : " + response);
        assertTrue(response > 0L);
        assertTrue(response == 2.0D);

    }

    @Test
    void validateRatioReturnZeroRatioHumanTest() {

        double response = mutantServiceImpl.validateRatio(Long.parseLong("0"), Long.valueOf(20));
        assertTrue(response == 0.0D);

    }

    @Test
    void validateGetStats() {

        when(mutantRepository.countByIsMutantValue(Mockito.any(Boolean.class)))
                .thenReturn(Optional.of(20L));

        StatsDTO statsDTO = mutantServiceImpl.getStats();
        System.out.println(" Stats : "+ statsDTO);
    }
}