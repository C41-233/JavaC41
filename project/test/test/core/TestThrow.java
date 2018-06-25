package test.core;

import static org.junit.Assert.*;
import static test.base.AssertEx.*;

import org.junit.Test;

public class TestThrow {

	@Test
	public void test() {
		try {
			assertEquals(1, calc(1));
		}
		catch (Exception e) {
			fail();
		}
		assertThrow(Exception.class, ()->calc(5));
	}

	private static int calc(int v) throws Exception {
		if(v == 5) {
			throw new Exception();
		}
		return v;
	}
	
}
