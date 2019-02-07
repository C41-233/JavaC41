package c41.utility;

import c41.reflect.StaticClassException;

public final class Convert {

	private Convert() {
		throw new StaticClassException();
	}

	public static byte toByte(Object val) {
		if(val instanceof Number) {
			return toByte((Number)val);
		}
		if(val instanceof String) {
			return toByte((String)val);
		}
		throw new ClassCastException();
	}
	
	public static byte toByte(Number val) {
		return val.byteValue();
	}
	
	public static byte toByte(String val) {
		return Byte.parseByte(val);
	}
	public static short toShort(Object val) {
		if(val instanceof Number) {
			return toShort((Number)val);
		}
		if(val instanceof String) {
			return toShort((String)val);
		}
		throw new ClassCastException();
	}
	
	public static short toShort(Number val) {
		return val.shortValue();
	}
	
	public static short toShort(String val) {
		return Short.parseShort(val);
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
	public static long toLong(Object val) {
		if(val instanceof Number) {
			return toLong((Number)val);
		}
		if(val instanceof String) {
			return toLong((String)val);
		}
		throw new ClassCastException();
	}
	
	public static long toLong(Number val) {
		return val.longValue();
	}
	
	public static long toLong(String val) {
		return Long.parseLong(val);
	}
	public static float toFloat(Object val) {
		if(val instanceof Number) {
			return toFloat((Number)val);
		}
		if(val instanceof String) {
			return toFloat((String)val);
		}
		throw new ClassCastException();
	}
	
	public static float toFloat(Number val) {
		return val.floatValue();
	}
	
	public static float toFloat(String val) {
		return Float.parseFloat(val);
	}
	public static double toDouble(Object val) {
		if(val instanceof Number) {
			return toDouble((Number)val);
		}
		if(val instanceof String) {
			return toDouble((String)val);
		}
		throw new ClassCastException();
	}
	
	public static double toDouble(Number val) {
		return val.doubleValue();
	}
	
	public static double toDouble(String val) {
		return Double.parseDouble(val);
	}
	
}
