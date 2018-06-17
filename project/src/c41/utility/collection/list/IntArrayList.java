
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class IntArrayList implements Iterable<Integer>{

	private int[] data;
	private int size;
	private int mod;
	
	public IntArrayList(){
		this(16);
	}
	
	public IntArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new int[capacity];
	}
	
	public IntArrayList(Iterable<Integer> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	public void add(int e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
	}
	
	public void addAll(Iterable<Integer> it){
		for(int val : it){
			add(val);
		}
	}
	
	public int set(int i, int value){
		checkRange(i);
		
		int old = data[i];
		data[i] = value;
		return old;
	}
	
	public int get(int i){
		checkRange(i);
		
		return data[i];
	}
	
	private void checkRange(int i){
		if(i < 0 || i >= size){
			throw new IndexOutOfBoundsException("out of range: " + i);
		}
	}
	
	private void expandCapacity(int size){
		if(size <= data.length){
			return;
		}
		
		int newSize = data.length >> 1;
		while(newSize < size){
			newSize >>= 1;
		}
		this.data = Arrays.copyOf(data, newSize);
		mod++;
	}
	
	public int size(){
		return this.size;
	}
	
	public void clear(){
		size = 0;
		mod++;
	}
	
	public int[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public Iterator<Integer> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Integer>{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Integer next() {
			checkVersion();
			
			return data[i++];
		}
	
		private void checkVersion(){
			if(version != mod){
				throw new ConcurrentModificationException();
			}
		}
	
	}
	
}