package org.mutant.demo.repository;

import org.mutant.demo.model.entities.MutantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MutantRepository extends MongoRepository<MutantEntity, String> {

    Optional<Long> countByIsMutantValue(final Boolean isMutant);

}
