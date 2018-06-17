package test.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import c41.utility.generator.ILongGenerator;
import c41.utility.generator.SequenceLongGenerator;

public class GeneratorTest {

	@Test
	public void test() {
		ILongGenerator generator = new SequenceLongGenerator(100);
		for(long i = 100; i<110; i++) {
			assertEquals(i, generator.nextLong());
		}
	}

}
