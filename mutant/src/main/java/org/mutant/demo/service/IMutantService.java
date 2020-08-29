package org.mutant.demo.service;

import org.mutant.demo.dto.StatsDTO;
import org.mutant.demo.enums.CircuitEnum;
import org.mutant.demo.util.DnaProcessor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public interface IMutantService {

    public static final Set<Character> VALID_SEQUENCE = new HashSet<>(Arrays.asList('A', 'T', 'C', 'G'));

    public static final int MAX_MATRIX = 1000;

    public static final int MUTANT_SEQUENCE_LENGTH = 4;

    public static final int MUTANT_ARRAY_LENGTH = 6;

    public static final int MUTANT_SEQUENCE_COUNT = 3;

    public Boolean mutant( final String[] dna);

    public StatsDTO getStats();

    public default Character validateEndProcessMutant(final DnaProcessor dnaProcessor, final CircuitEnum circuitEnum ) {
        dnaProcessor.getNext(circuitEnum);
        return dnaProcessor.getNext(circuitEnum);
    }

}
