package c41.utility.linq.enumerator;

import java.util.NoSuchElementException;

public abstract class ByteEnumeratorBase implements IByteEnumerator {

	@Override
	public abstract boolean hasNext();

	protected abstract byte doNext();
	
	@Override
	public final byte nextByte() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return doNext();
	}

}
