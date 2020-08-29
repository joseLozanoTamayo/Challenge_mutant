package org.mutant.demo.util;

import org.mutant.demo.enums.CircuitEnum;
import org.mutant.demo.enums.MutantProcessInitEnum;

import java.util.stream.Stream;

public class DnaProcessor {

    private final String[] dna;
    private final int dnaSize;
    private int row, col;
    private int rowStart, colStart;
    MutantProcessInitEnum start;
    CircuitEnum direction;

    public DnaProcessor(String[] dna, MutantProcessInitEnum start, CircuitEnum direction) {

        this.dna = dna;
        this.dnaSize = dna.length;
        this.row = 0;
        this.col = 0;
        this.start = start;
        this.direction = direction;
        this.rowStart = 0;
        this.colStart = 0;

        initConfig(start, direction);

    }

    private void initConfig (MutantProcessInitEnum mutantProcessInitEnum, CircuitEnum circuitEnum) {

        Stream.of(mutantProcessInitEnum)
                .parallel()
                .filter(mutantEnum -> mutantEnum.equals(MutantProcessInitEnum.BOTTOM) &&
                        direction == CircuitEnum.DAG_UP)
                .flatMap(this::apply)
                .filter(mutantEnum -> mutantEnum.equals(MutantProcessInitEnum.TOP) &&
                        direction == CircuitEnum.DAG_DOWN)
                .flatMap(this::apply);
    }

    public boolean nextStartDimension(MutantProcessInitEnum mutantProcessInitEnum) {
        return Stream.of(mutantProcessInitEnum)
                .parallel()
                .flatMap(this::validateNextInitMutantProcess)
                .findAny()
                .get();
    }

    public Character getValue() {
        if (row < 0 || row > dnaSize || col < 0 || col > dnaSize) {
            return null;
        }
        return dna[row].charAt(col);
    }

    public Character getNext(CircuitEnum direction) {

        return Stream.of(direction)
                .parallel()
                .flatMap(this::validateProcessEnum)
                .findAny()
                .orElse(null);
    }


    private Stream<MutantProcessInitEnum> apply(MutantProcessInitEnum item) {
        this.col = 1;
        this.colStart = 1;
        return Stream.of(item);
    }

    private Stream<Character> validateProcessEnum(final CircuitEnum item) {
        Boolean isValue = Boolean.FALSE;
        if (item.equals(CircuitEnum.RIGHT) && (col < dnaSize - 1)) {
            col = col + 1;
            isValue = Boolean.TRUE;
        } else if (item.equals(CircuitEnum.DOWN) && (row < dnaSize - 1)) {
            row = row + 1;
            isValue = Boolean.TRUE;
        } else if (item.equals(CircuitEnum.DAG_DOWN) && (row < dnaSize - 1 && col < dnaSize - 1)) {
            row = row + 1;
            col = col + 1;
            isValue = Boolean.TRUE;
        } else if (item.equals(CircuitEnum.DAG_UP) && (row > 0 && col < dnaSize - 1)) {
            row = row - 1;
            col = col + 1;
            isValue = Boolean.TRUE;
        }

        if (isValue) {
            return Stream.of(getValue());
        }

        return null;
    }

    private Stream<Boolean> validateNextInitMutantProcess(final MutantProcessInitEnum mutantProcessInitEnum) {
        if (mutantProcessInitEnum.equals(MutantProcessInitEnum.TOP) || mutantProcessInitEnum.equals(MutantProcessInitEnum.BOTTOM) ) {
            row = (mutantProcessInitEnum.equals(MutantProcessInitEnum.TOP)) ? 0 : dnaSize - 1;
            colStart = colStart + 1;
            col = colStart;
            return Stream.of(colStart < dnaSize);
        }
        col = 0;
        rowStart = rowStart + 1;
        row = rowStart;
        return Stream.of(rowStart < dnaSize);
    }
}


