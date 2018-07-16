package test.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import c41.utility.string.Strings;

public class StringTest {

	@Test
	public void removeLast() {
		assertEquals("abc", Strings.removeLast("abcdef", "def"));
		assertEquals("abc", Strings.removeLast("abc", "def"));
		assertEquals("abc", Strings.removeLast("abcabc", "abc"));
		assertEquals("abc", Strings.removeLast("abc", ""));
		assertEquals("", Strings.removeLast("", ""));
		assertEquals("", Strings.removeLast("", "a"));
	}

}
