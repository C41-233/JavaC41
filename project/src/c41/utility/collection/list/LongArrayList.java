
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class LongArrayList implements Iterable<Long>{

	private long[] data;
	private int size;
	private int mod;
	
	public LongArrayList(){
		this(16);
	}
	
	public LongArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new long[capacity];
	}
	
	public LongArrayList(Iterable<Long> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	public void add(long e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
	}
	
	public void addAll(Iterable<Long> it){
		for(long val : it){
			add(val);
		}
	}
	
	public long set(int i, long value){
		checkRange(i);
		
		long old = data[i];
		data[i] = value;
		return old;
	}
	
	public long get(int i){
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
	
	public long[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public Iterator<Long> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Long>{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Long next() {
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