package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class IntEnumeratorBase implements IIntEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract int doNext();
	
	@Override
	public final int nextInt() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
