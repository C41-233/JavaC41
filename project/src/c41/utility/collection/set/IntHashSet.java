
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class IntHashSet implements IIntCollection{

	private final HashSet<Integer> set = new HashSet<>();

	public IntHashSet(){
	
	}

	@Override
	public boolean add(int value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public IIntEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr implements IIntEnumerator{
	
		private final Iterator<Integer> iterator = set.iterator();
		private Integer current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public void moveNext() {
			current = iterator.next();
		}

		@Override
		public int currentInt() {
			return current;
		}
	
	}
	
}