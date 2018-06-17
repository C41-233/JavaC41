package c41.utility.collection.list;

import java.util.Iterator;
import java.util.List;

import c41.reflect.StaticClassException;
import c41.utility.collection.Iterators;

public final class ListViews {

	private ListViews() {
		throw new StaticClassException();
	}
	
	public static <T> IListView<T> of(List<T> list) {
		return new ListViewListWrapper<>(list);
	}

	public static <T> IListView<T> of(T[] array){
		return new ListViewArrayWrapper<>(array);
	}
	
	private static class ListViewListWrapper<T> implements IListView<T>{
	
		private final List<T> list; 
		
		public ListViewListWrapper(List<T> list) {
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
	
	private static class ListViewArrayWrapper<T> implements IListView<T>{
	
		private final T[] arr; 
		
		public ListViewArrayWrapper(T[] arr) {
			this.arr = arr;
		}
		
		@Override
		public Iterator<T> iterator() {
			return Iterators.of(arr);
		}
	
		@Override
		public int size() {
			return arr.length;
		}
	
		@Override
		public T get(int index) {
			return arr[index];
		}
		
	}
}
