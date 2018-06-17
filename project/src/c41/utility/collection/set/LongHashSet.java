
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class LongHashSet implements ILongCollection{

	private final HashSet<Long> set = new HashSet<>();

	public LongHashSet(){
	
	}

	@Override
	public boolean add(long value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public ILongEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr implements ILongEnumerator{
	
		private final Iterator<Long> iterator = set.iterator();
		private Long current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public void moveNext() {
			current = iterator.next();
		}

		@Override
		public long currentLong() {
			return current;
		}
	
	}
	
}