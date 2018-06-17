
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class ByteArrayList implements Iterable<Byte>{

	private byte[] data;
	private int size;
	private int mod;
	
	public ByteArrayList(){
		this(16);
	}
	
	public ByteArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new byte[capacity];
	}
	
	public ByteArrayList(Iterable<Byte> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	public void add(byte e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
	}
	
	public void addAll(Iterable<Byte> it){
		for(byte val : it){
			add(val);
		}
	}
	
	public byte set(int i, byte value){
		checkRange(i);
		
		byte old = data[i];
		data[i] = value;
		return old;
	}
	
	public byte get(int i){
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
	
	public byte[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public Iterator<Byte> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Byte>{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Byte next() {
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