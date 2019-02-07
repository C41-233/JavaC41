package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;
import c41.utility.linq.enumerator.ReferenceEnumeratorBase;

class ReferenceUnionEnumerable<T> implements IReferenceEnumerable<T>{

	private final IEnumerable<? extends T> enumerable1;
	private final IEnumerable<? extends T> enumerable2;
	
	public ReferenceUnionEnumerable(IEnumerable<? extends T> enumerable1, IEnumerable<? extends T> enumerable2) {
		Arguments.isNotNull(enumerable1);
		Arguments.isNotNull(enumerable2);
		
		this.enumerable1 = enumerable1;
		this.enumerable2 = enumerable2;
	}
	
	@Override
	public IEnumerator<T> iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends ReferenceEnumeratorBase<T>{

		private IEnumerator<? extends T> enumerator1 = enumerable1.iterator();
		private IEnumerator<? extends T> enumerator2 = null; //延迟构造
		
		@Override
		public boolean hasNext() {
			if(enumerator1 != null) {
				if(enumerator1.hasNext()) {
					return true;
				}
				enumerator1 = null;
				if(enumerator2 == null) {
					enumerator2 = enumerable2.iterator();
				}
			}
			return enumerator2.hasNext();
		}

		@Override
		public T doNext() {
			if(enumerator1 != null) {
				return enumerator1.next();
			}
			return enumerator2.next();
		}

	}
	
}
