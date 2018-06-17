
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class DoubleHashSet implements IDoubleCollection{

	private final HashSet<Double> set = new HashSet<>();

	public DoubleHashSet(){
	
	}

	@Override
	public boolean add(double value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public IDoubleEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr implements IDoubleEnumerator{
	
		private final Iterator<Double> iterator = set.iterator();
		private Double current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public void moveNext() {
			current = iterator.next();
		}

		@Override
		public double currentDouble() {
			return current;
		}
	
	}
	
}