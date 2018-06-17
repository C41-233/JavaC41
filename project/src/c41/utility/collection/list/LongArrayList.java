
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import c41.core.assertion.Arguments;
import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class LongArrayList implements ILongCollection, ILongListView{

	private long[] data;
	private int size;
	private int mod;
	
	public LongArrayList(){
		this(16);
	}
	
	public LongArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new long[capacity];
	}
	
	public LongArrayList(Iterable<Long> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	@Override
	public boolean add(long e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		return true;
	}
	
	public long set(int i, long value){
		checkRange(i);
		
		long old = data[i];
		data[i] = value;
		return old;
	}
	
	@Override
	public long get(int i){
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
	public long[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public ILongEnumerator iterator() {
		return new Itr();
	}
	
	private class Itr implements ILongEnumerator{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public long currentLong() {
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