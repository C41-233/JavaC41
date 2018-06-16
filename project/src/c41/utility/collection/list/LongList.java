
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class LongList implements Iterable<Long>{

	private long[] data;
	private int size;
	private int mod;
	
	public LongList(){
		this(16);
	}
	
	public LongList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new long[capacity];
	}
	
	public void add(long e){
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
	public Iterator<Long> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Long>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Long next() {
			return data[i++];
		}
	
	}
	
}