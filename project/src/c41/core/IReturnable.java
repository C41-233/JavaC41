package c41.core;

@FunctionalInterface
public interface IReturnable<T> {

	public T run() throws Throwable;
	
}
