package c41.utility.linq;

import java.util.Iterator;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;

class IterableEnumerable<T> implements IReferenceEnumerable<T>{
	
	protected final Iterable<T> iterable;
	
	public IterableEnumerable(Iterable<T> iterable) {
		Arguments.isNotNull(iterable);
		this.iterable = iterable;
	}

	@Override
	public IEnumerator<T> iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements IEnumerator<T>{

		private final Iterator<T> iterator = iterable.iterator();
		
		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public T next() {
			return iterator.next();
		}

	}
	
}