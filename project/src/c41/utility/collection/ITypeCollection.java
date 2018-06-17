package c41.utility.collection;

public interface ITypeCollection<T> {

	public void add(T obj);
	
	public void addAll(T[] array);
	
	public T[] toArray();
}
