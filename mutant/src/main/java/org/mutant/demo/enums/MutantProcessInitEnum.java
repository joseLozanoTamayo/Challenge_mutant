package org.mutant.demo.enums;

import org.mutant.demo.util.SearchStrategy;

import java.util.Arrays;
import java.util.List;

public enum MutantProcessInitEnum {

    LEFT, TOP, BOTTOM;

    public  static List<SearchStrategy> getDnaRun() {
        return Arrays.asList(new SearchStrategy(MutantProcessInitEnum.TOP, CircuitEnum.DOWN),
                new SearchStrategy(MutantProcessInitEnum.LEFT, CircuitEnum.RIGHT),
                new SearchStrategy(MutantProcessInitEnum.TOP, CircuitEnum.DAG_DOWN),
                new SearchStrategy(MutantProcessInitEnum.LEFT, CircuitEnum.DAG_DOWN),
                new SearchStrategy(MutantProcessInitEnum.LEFT, CircuitEnum.DAG_UP),
                new SearchStrategy(MutantProcessInitEnum.BOTTOM, CircuitEnum.DAG_UP));
    }

}
