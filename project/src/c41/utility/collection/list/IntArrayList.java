
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import c41.core.assertion.Arguments;
import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class IntArrayList implements IIntCollection{

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
	
	@Override
	public boolean add(int e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		return true;
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
	
	@Override
	public int size(){
		return this.size;
	}
	
	public void clear(){
		size = 0;
		mod++;
	}
	
	@Override
	public int[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public IIntEnumerator iterator() {
		return new Itr();
	}
	
	private class Itr implements IIntEnumerator{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public int currentInt() {
			return data[i++];
		}

		@Override
		public void moveNext(){
			checkVersion();
			++i;
		}
	
		private void checkVersion(){
			if(version != mod){
				throw new ConcurrentModificationException();
			}
		}
	
	}
	
}