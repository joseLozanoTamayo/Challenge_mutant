package org.mutant.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.mutant.demo.dto.StatsDTO;
import org.mutant.demo.enums.CircuitEnum;
import org.mutant.demo.enums.DnaCharacterEnum;
import org.mutant.demo.enums.MutantProcessInitEnum;
import org.mutant.demo.model.entities.MutantEntity;
import org.mutant.demo.repository.MutantRepository;
import org.mutant.demo.util.DnaProcessor;
import org.mutant.demo.util.SearchStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
@Slf4j
public class MutantServiceImpl implements IMutantService {

    @Autowired
    private MutantRepository mutantRepository;

    private String[] dna;

    @Override
    public Boolean mutant(String[] dna) {

        this.dna = dna;
        validateDnaSize();
        validateDnaStructure();

        return redisSave(dna, searchInAllDirections(dna));
    }

    @Override
    public StatsDTO getStats() {

        final Long mutant = mutantRepository.countByIsMutantValue(Boolean.TRUE).get();
        final Long human = mutantRepository.countByIsMutantValue(Boolean.FALSE).get();

        return StatsDTO.builder()
                .countHumanDna(mutant)
                .countMutantDna(human)
                .ratio(validateRatio(human, mutant))
                .build();
    }

    boolean searchInAllDirections(String[] dna) {
        Integer count = 0;
        for (SearchStrategy searchStrategy : MutantProcessInitEnum.getDnaRun()) {
            log.info(" searchStrategy : {} ", searchStrategy);
            count += searchUsingStrategy(dna, searchStrategy.getStart(), searchStrategy.getDirection());
            if (count >= MUTANT_SEQUENCE_COUNT) {
                log.info(" count ::: {} ", count);
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    Integer searchUsingStrategy(String[] dna, MutantProcessInitEnum mutantProcessInitEnum, CircuitEnum circuitEnum) {

        DnaProcessor dnaIterator = new DnaProcessor(dna, mutantProcessInitEnum, circuitEnum);
        int sequenceCount = 0;

        do {
            int counter = 1;
            Character prevChar = dnaIterator.getValue();

            Character curChar;
            while (Objects.nonNull(curChar = dnaIterator.getNext(circuitEnum))) {

                if (curChar.equals(prevChar)) {
                    counter++;
                } else {
                    prevChar = curChar;
                    counter = 1;
                }

                if (counter == MUTANT_SEQUENCE_LENGTH) {

                    log.info(" sequenceCount return : {} ", sequenceCount);
                    return 1;
                }
            }
        } while (dnaIterator.nextStartDimension(mutantProcessInitEnum));

        log.info(" sequenceCount down : {} ", sequenceCount);
        return sequenceCount;
    }

    public void validateDnaSize() {

        System.out.println("Entro a validateDnaSize  -> " + this.dna.length);

        Arrays.stream(this.dna)
                .parallel()
                .filter(dnaMutant -> Objects.nonNull(dna))
                .filter(dnaMutant -> dnaMutant.length() > 0 )
                .filter(dnaMutant -> {
                    return dnaMutant.length() <= IMutantService.MUTANT_ARRAY_LENGTH;
                })
                .map(dnaMutant -> Boolean.TRUE)
                .findAny()
                .orElseThrow(() -> new RuntimeException("validating error size array"));
    }

    public void validateDnaStructure() {
        log.info(" Validar adn structure : this.dna " + this.dna );
        Arrays.stream(this.dna)
                .forEach(charItem -> {
                    charItem.chars().forEach(value -> {
                        DnaCharacterEnum.validateDnaContent(Character.toString((char) value));
                    });
                });
    }

    private Boolean redisSave( final String [] dna, final Boolean isMutant ){
        redisPersistence(dna, isMutant);
        return isMutant;
    }

    @Async
    private Boolean redisPersistence( final String [] dna, final Boolean isMutant ){

        this.mutantRepository.save(MutantEntity.builder()
                .id(String.join("-", dna))
                .isMutantValue(isMutant)
                .build());

        return isMutant;
    }

    public double validateRatio(final double human, final double mutant) {

        log.info(" validate Ratio ::: human : {} mutant : {}", human, mutant);
        long ratio = 0;

        if ( mutant == 0) {
            return ratio;
        }

        return ( human / mutant);

    }
}
