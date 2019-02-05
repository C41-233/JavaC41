package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class DoubleEnumeratorBase implements IDoubleEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract double doNext();
	
	@Override
	public final double nextDouble() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
