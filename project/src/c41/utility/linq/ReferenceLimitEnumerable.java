package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;
import c41.utility.linq.enumerator.ReferenceEnumeratorBase;

class ReferenceLimitEnumerable<T> implements IReferenceEnumerable<T>{

	private final IEnumerable<T> enumerable;
	private final int limit;
	
	public ReferenceLimitEnumerable(IEnumerable<T> enumerable, int limit) {
		Arguments.isNotNull(enumerable);
		Arguments.is(limit >= 0, "limit<0 : %d", limit);
		
		this.enumerable = enumerable;
		this.limit = limit;
	}
	
	
	@Override
	public IEnumerator<T> iterator() {
		return new Enumerator();
	}

	private class Enumerator extends ReferenceEnumeratorBase<T>{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		private int n;
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext() && n < limit;
		}

		@Override
		protected T doNext() {
			T current = enumerator.next();
			n++;
			return current;
		}
		
	}
	
}
