package org.mutant.demo.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MutantDTO implements Serializable {

    private String[] dna;


}
