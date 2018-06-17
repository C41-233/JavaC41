package c41.utility.linq;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import c41.core.assertion.Arguments;

class ListEnumerable<T> extends IterableEnumerable<T>{
	
	public ListEnumerable(List<T> list) {
		super(list);
		this.list = list;
	} 
	
	private final List<T> list;
	
	@Override
	public T at(int i) {
		Arguments.is(i>=0, "%d < 0", i);
		
		if(i >= list.size()) {
			throw new NoSuchElementException();
		}
		return list.get(i);
	}
	
	@Override
	public int count() {
		return list.size();
	}
	
	@Override
	public Object[] toArray() {
		return list.toArray();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(Class<T> type) {
		T[] arr = (T[]) Array.newInstance(type, list.size());
		return super.toArray(arr);
	}
	
	@Override
	public T[] toArray(T[] array) {
		return list.toArray(array);
	}
	
	@Override
	public List<T> toList() {
		return new ArrayList<>(list);
	}
	
}