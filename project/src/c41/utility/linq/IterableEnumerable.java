package c41.utility.linq;

import java.util.Iterator;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;

class IterableEnumerable<T> implements IReferenceEnumerable<T>{
	
	private final Iterable<T> iterable;
	
	public IterableEnumerable(Iterable<T> iterable) {
		Arguments.isNotNull(iterable);
		this.iterable = iterable;
	}

	@Override
	public IEnumerator<T> iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator extends ReferenceEnumeratorBase<T>{

		private final Iterator<T> iterator = iterable.iterator();
		
		private T current;
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public void doMoveNext() {
			current = iterator.next();
		}

		@Override
		public T doCurrent() {
			return current;
		}
		
	}
	
}