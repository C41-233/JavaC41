package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class ShortEnumeratorBase implements IShortEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract short doNext();
	
	@Override
	public final short nextShort() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
