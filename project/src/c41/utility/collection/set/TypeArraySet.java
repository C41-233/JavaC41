package c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.ITypeCollection;
import c41.utility.collection.list.TypeArrayList;

public class TypeArraySet<T> implements ITypeCollection<T>{

	private final TypeArrayList<T> list;
	private final HashSet<T> set = new HashSet<>();
	
	public TypeArraySet(Class<T> clazz) {
		this.list = new TypeArrayList<>(clazz);
	}
			
	@Override
	public void add(T obj) {
		if(set.add(obj)) {
			list.add(obj);
		}
	}

	@Override
	public void addAll(T[] array) {
		for(T obj : array) {
			add(obj);
		}
	}

	@Override
	public T[] toArray() {
		return list.toArray();
	}

	@Override
	public Iterator<T> iterator() {
		return set.iterator();
	}

	@Override
	public int size() {
		return set.size();
	}

}
