package c41.utility.linq;

import java.util.Enumeration;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;

class EnumerationEnumerable<T> implements IReferenceEnumerable<T> {

	private final Enumerator enumerator;
	
	public EnumerationEnumerable(Enumeration<T> enumeration) {
		Arguments.isNotNull(enumeration);
		this.enumerator = new Enumerator(enumeration);
	}
	
	@Override
	public IEnumerator<T> iterator() {
		return enumerator;
	}

	private final class Enumerator implements IEnumerator<T>{

		private final Enumeration<T> enumeration;
		
		public Enumerator(Enumeration<T> enumeration) {
			this.enumeration = enumeration;
		}
		
		@Override
		public boolean hasNext() {
			return enumeration.hasMoreElements();
		}

		@Override
		public T next() {
			return enumeration.nextElement();
		}

	}
	
}
