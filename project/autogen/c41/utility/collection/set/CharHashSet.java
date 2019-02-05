
package  c41.utility.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import c41.utility.collection.*;
import c41.utility.linq.enumerator.*;

public class CharHashSet implements ICharCollection{

	private final HashSet<Character> set = new HashSet<>();

	public CharHashSet(){
	
	}

	@Override
	public boolean add(char value){
		return set.add(value);
	}

	@Override
	public int size(){
		return set.size();
	}

	@Override
	public ICharEnumerator iterator(){
		return new Itr();
	}
	
	private class Itr extends CharEnumeratorBase{
	
		private final Iterator<Character> iterator = set.iterator();
		private Character current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		protected char doNext() {
			return current;
		}
	
	}
	
}