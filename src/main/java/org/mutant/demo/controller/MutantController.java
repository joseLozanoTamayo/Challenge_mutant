package org.mutant.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.mutant.demo.dto.MutantDTO;
import org.mutant.demo.dto.StatsDTO;
import org.mutant.demo.service.IMutantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
@Slf4j
public class MutantController {

    private IMutantService mutantService;

    public MutantController(IMutantService mutantService) {
        this.mutantService = mutantService;

    }

    @GetMapping( path = "/stats", consumes = "application/json", produces = "application/json")
    public StatsDTO getStats() {
        return mutantService.getStats();
    }

    @PostMapping(path = "/mutant", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> isMutant(@RequestBody final MutantDTO mutantDTO) {
        return ResponseEntity
                .ok(mutantService.mutant( mutantDTO.getDna()));
    }
}
