package c41.utility.linq;

import java.util.NoSuchElementException;

import c41.utility.linq.enumerator.ICharEnumerator;

abstract class CharEnumeratorBase implements ICharEnumerator{

	private boolean isBefore = true;
	
	@Override
	public final void moveNext() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		doMoveNext();
		isBefore = false;
	}
	
	protected abstract void doMoveNext();

	@Override
	public final char currentChar() {
		if(isBefore) {
			throw new NoSuchElementException();
		}
		return doCurrentChar();
	}
	
	protected abstract char doCurrentChar();
	
}
