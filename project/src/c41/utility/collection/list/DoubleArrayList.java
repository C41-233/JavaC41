
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class DoubleArrayList implements Iterable<Double>{

	private double[] data;
	private int size;
	private int mod;
	
	public DoubleArrayList(){
		this(16);
	}
	
	public DoubleArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new double[capacity];
	}
	
	public DoubleArrayList(Iterable<Double> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	public void add(double e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
	}
	
	public void addAll(Iterable<Double> it){
		for(double val : it){
			add(val);
		}
	}
	
	public double set(int i, double value){
		checkRange(i);
		
		double old = data[i];
		data[i] = value;
		return old;
	}
	
	public double get(int i){
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
	
	public double[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public Iterator<Double> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Double>{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Double next() {
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