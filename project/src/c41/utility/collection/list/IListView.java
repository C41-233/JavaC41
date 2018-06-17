package c41.utility.collection.list;

public interface IListView<T> extends Iterable<T>{

	public int size();
	
	public T get(int index);
	
}
