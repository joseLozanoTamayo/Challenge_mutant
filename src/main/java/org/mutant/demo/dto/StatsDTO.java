package org.mutant.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StatsDTO {

    @JsonProperty("count_mutant_dna")
    private Long countMutantDna;

    @JsonProperty("count_human_dna")
    private Long countHumanDna;

    private double ratio;

}
