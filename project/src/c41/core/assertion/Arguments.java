package c41.core.assertion;

import c41.utility.string.Strings;

public final class Arguments{

	private Arguments() {}
	
	public static void is(boolean value, String format, Object...args) {
		if(value == false) {
			throw new IllegalArgumentException(Strings.format(format, args));
		}
	}
	
	public static void isNotNull(Object obj) {
		if(obj == null) {
			throw new ArgumentNullException();
		}
	}
	
	public static void isNotEmpty(String value) {
		isNotNull(value);
		is(value.trim().isEmpty()==false, "require string not empty");
	}
	
	public static void isAllNotEmpty(String[] values) {
		isNotNull(values);
		for(String value : values) {
			isNotEmpty(value);
		}
	}
	
	public static void isAllNotEmpty(Iterable<String> values) {
		isNotNull(values);
		for(String value : values) {
			isNotEmpty(value);
		}
	}
	
	public static void isMatch(String value, String regex) {
		Arguments.isNotNull(value);
		is(value.matches(regex), "[%s] not match [%s]", value, regex);
	}
	
}
