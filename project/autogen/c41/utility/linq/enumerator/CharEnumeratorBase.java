package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class CharEnumeratorBase implements ICharEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract char doNext();
	
	@Override
	public final char nextChar() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
