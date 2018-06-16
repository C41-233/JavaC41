
package c41.utility.collection.list;

import java.util.Arrays;
import java.util.Iterator;

import c41.core.assertion.Arguments;

public class CharList implements Iterable<Character>{

	private char[] data;
	private int size;
	private int mod;
	
	public CharList(){
		this(16);
	}
	
	public CharList(int capacity){
		Arguments.is(capacity>=0, "Illegal capacity: %d", capacity);
		
		this.data = new char[capacity];
	}
	
	public void add(char e){
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
	public Iterator<Character> iterator() {
		return new It();
	}
	
	private class It implements Iterator<Character>{
	
		private int i;
		
		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public Character next() {
			return data[i++];
		}
	
	}
	
}