package c41.utility.linq;

import java.util.Iterator;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;

class IteratorEnumerable<T> implements IReferenceEnumerable<T> {

	private final Enumerator enumerator;
	
	public IteratorEnumerable(Iterator<T> iterator) {
		Arguments.isNotNull(iterator);
		this.enumerator = new Enumerator(iterator);
	}
	
	@Override
	public IEnumerator<T> iterator() {
		return enumerator;
	}

	private final class Enumerator implements IEnumerator<T>{

		private final Iterator<T> iterator;
		
		public Enumerator(Iterator<T> iterator) {
			this.iterator = iterator;
		}
		
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
