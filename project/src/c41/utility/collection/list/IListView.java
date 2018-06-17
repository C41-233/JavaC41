package c41.utility.collection.list;

import java.util.Iterator;
import java.util.List;

public interface IListView<T> extends Iterable<T>{

	public int size();
	
	public T get(int index);
	
	public static <T> IListView<T> of(List<T> list) {
		return new ListViewWrapper<>(list);
	}
	
}

class ListViewWrapper<T> implements IListView<T>{

	private final List<T> list; 
	
	public ListViewWrapper(List<T> list) {
		this.list = list;
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}
	
}
