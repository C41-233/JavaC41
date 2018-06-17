
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;

import c41.core.assertion.Arguments;
import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class CharArrayList implements ICharCollection{

	private char[] data;
	private int size;
	private int mod;
	
	public CharArrayList(){
		this(16);
	}
	
	public CharArrayList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new char[capacity];
	}
	
	public CharArrayList(Iterable<Character> it){
		this();
		Arguments.isNotNull(it);
		addAll(it);
	}
	
	@Override
	public boolean add(char e){
		expandCapacity(size+1);
		data[size] = e;
		size++;
		return true;
	}
	
	public char set(int i, char value){
		checkRange(i);
		
		char old = data[i];
		data[i] = value;
		return old;
	}
	
	public char get(int i){
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
	public char[] toArray(){
		return Arrays.copyOf(data, size);
	}
	
	@Override
	public ICharEnumerator iterator() {
		return new Itr();
	}
	
	private class Itr implements ICharEnumerator{
	
		private int i;
		private int version = mod;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public char currentChar() {
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