package c41.reflect;

import java.util.HashMap;

import c41.cache.WeakMemoryCache;
import c41.core.Core;

public final class Types {

	private Types() {
		throw new StaticClassException();
	}

	private static final WeakMemoryCache<Class, TypeInfo> classes = new WeakMemoryCache<>();
	
	@SuppressWarnings("unchecked")
	public static <T> TypeInfo<T> typeOf(Class<T> clazz){
		if(clazz == null) {
			return null;
		}
		
		return classes.getOrCreate(clazz, ()->new TypeInfo<>(clazz));
	}
	
	public static TypeInfo<?> typeOf(String clazz){
		try {
			return typeOf(Class.forName(clazz));
		} catch (ClassNotFoundException e) {
			throw Core.throwException(e);
		}
	}

	private static final HashMap<Class, Class> primitiveToBox = new HashMap<>();
	private static final HashMap<Class, Class> boxToPrimitive = new HashMap<>();
	
	private static void register_box(Class primitive, Class box) {
		primitiveToBox.put(primitive, box);
		boxToPrimitive.put(box, primitive);
	}
	
	static {
		register_box(boolean.class, Boolean.class);
		register_box(byte.class, Byte.class);
		register_box(short.class, Short.class);
		register_box(int.class, Integer.class);
		register_box(long.class, Long.class);
		register_box(char.class, Character.class);
		register_box(float.class, Float.class);
		register_box(double.class, Double.class);
		register_box(void.class, Void.class);
	}
	
	public static Class<?> toBoxClass(Class<?> type) {
		Class cl = primitiveToBox.get(type);
		return cl != null ? cl : type;
	}
	
	public static Class<?> toPrimitiveClass(Class<?> type) {
		Class cl = boxToPrimitive.get(type);
		return cl != null ? cl : type;
	}

	
}
