package org.mutant.demo;

import org.junit.jupiter.api.Test;
import org.mutant.demo.dto.MutantDTO;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
class MutantApplicationTests {

	@Test
	void contextLoads() {
		String[] process = {"arg1", "arg2"};

		MutantDTO mutantDTO =  new MutantDTO();
		mutantDTO.setDna(process);

		assertTrue(Objects.nonNull(mutantDTO));
		assertEquals("arg1", mutantDTO.getDna()[0]);
	}

}
