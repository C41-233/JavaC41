
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import c41.core.assertion.Arguments;
import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class FloatArrayList implements IFloatCollection{

	private float[] data;
	private int size;
	private int mod;
	
	public FloatArrayList(){
		this(16);
	}
	
	public FloatArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new float[capacity];
	}
	
	public FloatArrayList(Iterable<Float> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	@Override
	public boolean add(float e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		return true;
	}
	
	public float set(int i, float value){
		checkRange(i);
		
		float old = data[i];
		data[i] = value;
		return old;
	}
	
	public float get(int i){
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
	
	@Override
	public int size(){
		return this.size;
	}
	
	public void clear(){
		size = 0;
		mod++;
	}
	
	@Override
	public float[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public IFloatEnumerator iterator() {
		return new Itr();
	}
	
	private class Itr implements IFloatEnumerator{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public float currentFloat() {
			return data[i++];
		}

		@Override
		public void moveNext(){
			checkVersion();
			++i;
		}
	
		private void checkVersion(){
			if(version != mod){
				throw new ConcurrentModificationException();
			}
		}
	
	}
	
}