package c41.utility.linq;

import java.util.NoSuchElementException;

import c41.utility.linq.enumerator.IEnumerator;

abstract class ReferenceEnumeratorBase<T> implements IEnumerator<T>{

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
	public final T current() {
		if(isBefore) {
			throw new NoSuchElementException();
		}
		return doCurrent();
	}
	
	protected abstract T doCurrent();
}
