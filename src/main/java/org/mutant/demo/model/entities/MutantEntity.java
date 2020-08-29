package org.mutant.demo.model.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class MutantEntity {
    @Id
    private String id;

    private boolean isMutantValue;

}
