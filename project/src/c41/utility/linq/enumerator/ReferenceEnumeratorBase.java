package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class ReferenceEnumeratorBase<T> implements IEnumerator<T> {

	@Override
	public abstract boolean hasNext();

	protected abstract T doNext();
	
	@Override
	public final T next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
