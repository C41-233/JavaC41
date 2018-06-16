
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class DoubleList implements Iterable<Double>{

	private double[] data;
	private int size;
	private int mod;
	
	public DoubleList(){
		this(16);
	}
	
	public DoubleList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new double[capacity];
	}
	
	public void add(double e){
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
	public Iterator<Double> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Double>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Double next() {
			return data[i++];
		}
	
	}
	
}