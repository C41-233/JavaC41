package c41.utility.collection;

import c41.reflect.StaticClassException;

public final class Arrays {

	private Arrays() {
		throw new StaticClassException();
	}
	
	public static <T1, T2> boolean equalsByReference(T1[] arrays1, T2[] arrays2) {
		if(arrays1 == arrays2) {
			return true;
		}
		if(arrays1 == null || arrays2 == null) {
			return false;
		}
		if(arrays1.length != arrays2.length) {
			return false;
		}
		int length = arrays1.length;
		for(int i=0; i<length; i++) {
			if(arrays1[i] != arrays2[i]) {
				return false;
			}
		}
		return true;
	}
	
}
