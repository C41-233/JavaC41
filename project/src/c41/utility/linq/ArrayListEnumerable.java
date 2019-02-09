package c41.utility.linq;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import c41.core.assertion.Arguments;

class ArrayListEnumerable<T> extends IterableEnumerable<T>{
	
	public ArrayListEnumerable(ArrayList<T> list) {
		super(list);
	} 
	
	private ArrayList<T> list(){
		return (ArrayList<T>)iterable;
	}
	
	@Override
	public T at(int i) {
		Arguments.is(i>=0, "%d < 0", i);
		
		if(i >= list().size()) {
			throw new NoSuchElementException();
		}
		return list().get(i);
	}
	
	@Override
	public int count() {
		return list().size();
	}
	
	@Override
	public T first() {
		if(list().size() == 0) {
			throw new NoSuchElementException();
		}
		return list().get(0);
	}

	@Override
	public Object[] toArray() {
		return list().toArray();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(Class<T> type) {
		T[] arr = (T[]) Array.newInstance(type, list().size());
		return list().toArray(arr);
	}
	
	@Override
	public T[] toArray(T[] array) {
		return list().toArray(array);
	}
	
	@Override
	public List<T> toList() {
		return new ArrayList<>(list());
	}
	
}