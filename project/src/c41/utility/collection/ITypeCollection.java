package c41.utility.collection;

public interface ITypeCollection<T> extends Iterable<T>{

	public void add(T obj);
	
	public default void addAll(T[] array) {
		for(T val : array) {
			add(val);
		}
	}
	
	public int size();
	
	public T[] toArray();
}
