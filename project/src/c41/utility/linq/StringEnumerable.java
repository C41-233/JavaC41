package c41.utility.linq;

import c41.utility.linq.enumerator.ICharEnumerator;

class StringEnumerable implements ICharEnumerable{

	private final String str;
	private final int length;
	
	public StringEnumerable(String str) {
		this.str = str;
		this.length = str.length();
	}
	
	@Override
	public ICharEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends CharEnumeratorBase{
		
		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < length;
		}
		
		@Override
		protected void doMoveNext() {
			++i;
		}
		
		@Override
		protected char doCurrentChar() {
			return str.charAt(i);
		}
		
	}
	
}
