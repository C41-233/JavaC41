
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class FloatList implements Iterable<Float>{

	private float[] data;
	private int size;
	private int mod;
	
	public FloatList(){
		this(16);
	}
	
	public FloatList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new float[capacity];
	}
	
	public void add(float e){
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
	public Iterator<Float> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Float>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Float next() {
			return data[i++];
		}
	
	}
	
}