
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class IntList implements Iterable<Integer>{

	private int[] data;
	private int size;
	private int mod;
	
	public IntList(){
		this(16);
	}
	
	public IntList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new int[capacity];
	}
	
	public void add(int e){
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
	public Iterator<Integer> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Integer>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Integer next() {
			return data[i++];
		}
	
	}
	
}