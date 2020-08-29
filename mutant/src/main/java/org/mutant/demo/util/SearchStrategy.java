package org.mutant.demo.util;

import lombok.Getter;
import lombok.ToString;
import org.mutant.demo.enums.CircuitEnum;
import org.mutant.demo.enums.MutantProcessInitEnum;

@Getter
@ToString
public class SearchStrategy {

    private MutantProcessInitEnum start;
    private CircuitEnum direction;

    public SearchStrategy(MutantProcessInitEnum start, CircuitEnum direction) {
        this.start = start;
        this.direction = direction;
    }

    public MutantProcessInitEnum getStart() {
        return this.start;
    }

    public CircuitEnum getDirection() {
        return this.direction;
    }
}

