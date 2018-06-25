package test.base;

import static org.junit.Assert.fail;

import c41.core.IRunnable;

public class AssertEx {

	public static <T extends Throwable> void assertThrow(Class<T> cl, IRunnable action) {
		try {
			action.run();
		}
		catch (Throwable e) {
			if(cl.isInstance(e)) {
				return;
			}
		}
		fail();
	}
	
}
