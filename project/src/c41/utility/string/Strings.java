package c41.utility.string;

import c41.reflect.StaticClassException;

public final class Strings{

	public static final String Empty = "";
	
	private Strings() {
		throw new StaticClassException();
	}
	
	public static String format(String format, Object... args) {
		if(args.length == 0) {
			return format;
		}
		return String.format(format, args);
	}

	public static String[] splitByWhitespace(String string) {
		return string.split("(\\s|　)+");
	}
	
	public static String of(Object...objects) {
		StringBuilder sb = new StringBuilder();
		for(Object object : objects) {
			sb.append(object);
		}
		return sb.toString();
	}
	
	public static String removeLast(String string, String token) {
		if(string.endsWith(token)) {
			return string.substring(0, string.length() - token.length());
		}
		return string;
	}
	
}
