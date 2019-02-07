package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.CharEnumeratorBase;
import c41.utility.linq.enumerator.ICharEnumerator;

class StringEnumerable implements ICharEnumerable{

	private final String str;
	
	public StringEnumerable(String str) {
		Arguments.isNotNull(str);
		this.str = str;
	}
	
	@Override
	public ICharEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends CharEnumeratorBase{
		
		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < str.length();
		}
		
		@Override
		protected char doNext() {
			return str.charAt(++i);
		}
		
	}
	
}
