package org.mutant.demo.enums;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public enum DnaCharacterEnum {
    A,
    T,
    C,
    G;

    public static Boolean validateDnaContent( final String character ) {
        return Arrays.stream(values())
                .filter(charEnum -> charEnum.name().equalsIgnoreCase(character))
                .map(value -> Boolean.TRUE)
                .findAny()
                .orElseThrow(() -> new RuntimeException("validating structure dna"));

    }
}
