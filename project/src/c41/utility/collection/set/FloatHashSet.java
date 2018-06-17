
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class FloatHashSet implements IFloatCollection{

	private final HashSet<Float> set = new HashSet<>();

	public FloatHashSet(){
	
	}

	@Override
	public boolean add(float value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public IFloatEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr implements IFloatEnumerator{
	
		private final Iterator<Float> iterator = set.iterator();
		private Float current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public void moveNext() {
			current = iterator.next();
		}

		@Override
		public float currentFloat() {
			return current;
		}
	
	}
	
}