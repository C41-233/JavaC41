package c41.utility.collection.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import c41.utility.collection.ITypeCollection;

public class TypeArrayList<T> implements ITypeCollection<T>, IListView<T>{

	private final Class<T> cl;
	private final ArrayList<T> list = new ArrayList<>();
	
	public TypeArrayList(Class<T> cl) {
		this.cl = cl;
	}
	
	@Override
	public void add(T obj) {
		list.add(obj);
	}
	
	@Override
	@SuppressWarnings("unchecked") 
	public T[] toArray() {
		T[] arr = (T[]) Array.newInstance(cl, list.size());
		return list.toArray(arr);
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}

	@Override
	public int size() {
		return list.size();
	}

}
