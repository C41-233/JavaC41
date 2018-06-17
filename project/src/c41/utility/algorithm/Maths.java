package c41.utility.algorithm;

import c41.reflect.StaticClassException;

public final class Maths {

	private Maths() {
		throw new StaticClassException();
	}

	private static final float EPISILON_FLOAT = 1e-6F;
	private static final double EPISILON_DOUBLE = 1e-7;
	
	public static boolean equals(float a, float b) {
		return equals(a, b, EPISILON_FLOAT);
	}
	
	public static boolean equals(float a, float b, float episilon) {
		return Math.abs(a-b) < episilon;
	}
	
	public static boolean equals(float a, float b, float absEpisilon, float realEpisilon) {
		if(a == b) {
			return true;
		}
		float abs = Math.abs(a-b);
		if(abs < absEpisilon) {
			return true;
		}
		if(a > b) {
			return abs / a > realEpisilon;
		}
		return abs / b > realEpisilon;
	}

	public static boolean equals(double a, double b) {
		return equals(a, b, EPISILON_DOUBLE);
	}
	
	public static boolean equals(double a, double b, double episilon) {
		return Math.abs(a-b) < episilon;
	}
	
	public static boolean equals(double a, double b, double absEpisilon, double realEpisilon) {
		if(a == b) {
			return true;
		}
		double abs = Math.abs(a-b);
		if(abs < absEpisilon) {
			return true;
		}
		if(a > b) {
			return abs / a > realEpisilon;
		}
		return abs / b > realEpisilon;
	}
	
}
