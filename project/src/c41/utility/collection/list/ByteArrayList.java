
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import c41.core.assertion.Arguments;
import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class ByteArrayList implements IByteCollection, IByteListView{

	private byte[] data;
	private int size;
	private int mod;
	
	public ByteArrayList(){
		this(16);
	}
	
	public ByteArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new byte[capacity];
	}
	
	public ByteArrayList(Iterable<Byte> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	@Override
	public boolean add(byte e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		return true;
	}
	
	public byte set(int i, byte value){
		checkRange(i);
		
		byte old = data[i];
		data[i] = value;
		return old;
	}
	
	@Override
	public byte get(int i){
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
	public byte[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public IByteEnumerator iterator() {
		return new Itr();
	}
	
	private class Itr implements IByteEnumerator{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public byte currentByte() {
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