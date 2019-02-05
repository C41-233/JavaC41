package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class FloatEnumeratorBase implements IFloatEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract float doNext();
	
	@Override
	public final float nextFloat() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
