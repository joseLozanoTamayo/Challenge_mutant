package org.mutant.demo.dto;

import lombok.*;
import org.mutant.demo.enums.CircuitEnum;
import org.mutant.demo.enums.MutantProcessInitEnum;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MutantProcessVarDTO {

    private String[] arrayMutant;
    private Integer arrayMutantSize;
    private Integer row;
    private Integer column;
    private Integer rowStart;
    private Integer colStart;
    private MutantProcessInitEnum mutantProcessInitEnum;
    private CircuitEnum circuitEnum;

}
