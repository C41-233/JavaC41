
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class ByteList implements Iterable<Byte>{

	private byte[] data;
	private int size;
	private int mod;
	
	public ByteList(){
		this(16);
	}
	
	public ByteList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new byte[capacity];
	}
	
	public void add(byte e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		mod++;
	}
	
	private void expandCapacity(int size){
		if(size > data.length){
			this.data = Arrays.copyOf(data, data.length * 2);
		}
	}
	
	public int size(){
		return this.size;
	}
	
	@Override
	public Iterator<Byte> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Byte>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Byte next() {
			return data[i++];
		}
	
	}
	
}