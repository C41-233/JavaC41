package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class LongEnumeratorBase implements ILongEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract long doNext();
	
	@Override
	public final long nextLong() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
