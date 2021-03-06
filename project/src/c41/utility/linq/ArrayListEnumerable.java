package c41.utility.linq;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import c41.core.assertion.Arguments;
import c41.lambda.function.IFunction;

class ArrayListEnumerable<T> extends IterableEnumerable<T>{
	
	private final ArrayList<T> list;
	
	public ArrayListEnumerable(ArrayList<T> list) {
		super(list);
		this.list = list;
	} 
	
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
	public T first() {
		if(list.size() == 0) {
			throw new NoSuchElementException();
		}
		return list.get(0);
	}

	@Override
	public T firstOrDefault() {
		if(list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public T firstOrDefault(T defaultValue) {
		if(list.size() == 0) {
			return defaultValue;
		}
		return list.get(0);
	}

	@Override
	public T firstOrCreateDefault(IFunction<? extends T> defaultValueProvider) {
		if(list.size() == 0) {
			return defaultValueProvider.invoke();
		}
		return list.get(0);
	}
	
	@Override
	public T last() {
		if(list.size() == 0) {
			throw new NoSuchElementException();
		}
		return list.get(list.size() - 1);
	}
	
	@Override
	public T lastOrDefault() {
		if(list.size() == 0) {
			return null;
		}
		return list.get(list.size() - 1);
	}
	
	@Override
	public T lastOrDefault(T defaultValue) {
		if(list.size() == 0) {
			return defaultValue;
		}
		return list.get(list.size() - 1);
	}
	
	@Override
	public Object[] toArray() {
		return list.toArray();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(Class<T> type) {
		T[] arr = (T[]) Array.newInstance(type, list.size());
		return list.toArray(arr);
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