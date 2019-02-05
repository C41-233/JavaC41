
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import c41.core.assertion.Arguments;
import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class ShortArrayList implements IShortCollection, IShortListView{

	private short[] data;
	private int size;
	private int mod;
	
	public ShortArrayList(){
		this(16);
	}
	
	public ShortArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new short[capacity];
	}
	
	public ShortArrayList(Iterable<Short> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	@Override
	public boolean add(short e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		return true;
	}
	
	public short set(int i, short value){
		checkRange(i);
		
		short old = data[i];
		data[i] = value;
		return old;
	}
	
	@Override
	public short get(int i){
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
	public short[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public IShortEnumerator iterator() {
		return new Itr();
	}
	
	private class Itr extends ShortEnumeratorBase{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		protected short doNext(){
			checkVersion();
			return data[++i];
		}
	
		private void checkVersion(){
			if(version != mod){
				throw new ConcurrentModificationException();
			}
		}
	
	}
	
}