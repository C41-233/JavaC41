
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class ShortArrayList implements Iterable<Short>{

	private short[] data;
	private int size;
	private int mod;
	
	public ShortArrayList(){
		this(16);
	}
	
	public ShortArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new short[capacity];
	}
	
	public ShortArrayList(Iterable<Short> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	public void add(short e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
	}
	
	public void addAll(Iterable<Short> it){
		for(short val : it){
			add(val);
		}
	}
	
	public short set(int i, short value){
		checkRange(i);
		
		short old = data[i];
		data[i] = value;
		return old;
	}
	
	public short get(int i){
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
	
	public short[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public Iterator<Short> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Short>{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Short next() {
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