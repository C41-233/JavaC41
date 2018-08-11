package test.utility;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import c41.utility.comparator.Comparators;
import c41.utility.string.Chars;

public class ComparatorTest {

	@Test
	public void test1() {
		String[] data = new String[]{"A", "an", "-", "D"};
		Arrays.sort(data,
			Comparators.<String>by(s -> s.equals("-"))
			.thenBy(s -> s.length() == 1 && Chars.isBasicLatinAlphabetUpperCase(s.charAt(0)))
			.thenBySelf()
		);
		assertArrayEquals(new String[] {"-", "A", "D", "an"}, data);
	}

}
