
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class ShortHashSet implements IShortCollection{

	private final HashSet<Short> set = new HashSet<>();

	public ShortHashSet(){
	
	}

	@Override
	public boolean add(short value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public IShortEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr implements IShortEnumerator{
	
		private final Iterator<Short> iterator = set.iterator();
		private Short current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public void moveNext() {
			current = iterator.next();
		}

		@Override
		public short currentShort() {
			return current;
		}
	
	}
	
}