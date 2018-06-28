package c41.utility;

import c41.reflect.StaticClassException;

public final class Convert {

	private Convert() {
		throw new StaticClassException();
	}
	
	public static int toInt(Object val) {
		if(val instanceof Number) {
			return toInt((Number)val);
		}
		if(val instanceof String) {
			return toInt((String)val);
		}
		throw new ClassCastException();
	}
	
	public static int toInt(Number val) {
		return val.intValue();
	}
	
	public static int toInt(String val) {
		return Integer.parseInt(val);
	}
	
}
