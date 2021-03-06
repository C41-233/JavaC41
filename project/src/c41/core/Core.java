package c41.core;

public final class Core {

	@SuppressWarnings("unchecked")
	public static <V, T> V cast(T obj) {
		return (V)obj;
	}
	
	public static <T extends Enum<T>> T asEnum(Class<T> enumClass, String value){
		try {
			return Enum.valueOf(enumClass, value);
		}
		catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	public static <T, V extends T> V as(Class<V> cl, T obj) {
		try {
			return cl.cast(obj);
		} catch (ClassCastException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <E extends Throwable> E throwRuntime(Throwable e) throws E{
		throw (E) e;
	}
	
	public static RuntimeException throwException(Throwable e) {
		return Core.<RuntimeException>throwRuntime(e);
	}

	public static void throwRun(IRunnable run) {
		try {
			run.run();
		}
		catch (Throwable e) {
			throw throwException(e);
		}
	}
	
	public static <T> T throwRun(IReturnable<T> run) {
		try {
			return run.run();
		} catch (Throwable e) {
			throw throwException(e);
		}
	}
	
}
