
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class ShortList implements Iterable<Short>{

	private short[] data;
	private int size;
	private int mod;
	
	public ShortList(){
		this(16);
	}
	
	public ShortList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new short[capacity];
	}
	
	public void add(short e){
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
	public Iterator<Short> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Short>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Short next() {
			return data[i++];
		}
	
	}
	
}