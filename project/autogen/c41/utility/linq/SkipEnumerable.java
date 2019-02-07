package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.*;


class ByteSkipEnumerable implements IByteEnumerable{

	private final IByteEnumerable enumerable;
	private final int skip;

	public ByteSkipEnumerable(IByteEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public IByteEnumerator iterator() {
		IByteEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextByte();
			}
		}
		return enumerator;
	}
	
}

class CharSkipEnumerable implements ICharEnumerable{

	private final ICharEnumerable enumerable;
	private final int skip;

	public CharSkipEnumerable(ICharEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public ICharEnumerator iterator() {
		ICharEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextChar();
			}
		}
		return enumerator;
	}
	
}

class ShortSkipEnumerable implements IShortEnumerable{

	private final IShortEnumerable enumerable;
	private final int skip;

	public ShortSkipEnumerable(IShortEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public IShortEnumerator iterator() {
		IShortEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextShort();
			}
		}
		return enumerator;
	}
	
}

class IntSkipEnumerable implements IIntEnumerable{

	private final IIntEnumerable enumerable;
	private final int skip;

	public IntSkipEnumerable(IIntEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public IIntEnumerator iterator() {
		IIntEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextInt();
			}
		}
		return enumerator;
	}
	
}

class LongSkipEnumerable implements ILongEnumerable{

	private final ILongEnumerable enumerable;
	private final int skip;

	public LongSkipEnumerable(ILongEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public ILongEnumerator iterator() {
		ILongEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextLong();
			}
		}
		return enumerator;
	}
	
}

class FloatSkipEnumerable implements IFloatEnumerable{

	private final IFloatEnumerable enumerable;
	private final int skip;

	public FloatSkipEnumerable(IFloatEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public IFloatEnumerator iterator() {
		IFloatEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextFloat();
			}
		}
		return enumerator;
	}
	
}

class DoubleSkipEnumerable implements IDoubleEnumerable{

	private final IDoubleEnumerable enumerable;
	private final int skip;

	public DoubleSkipEnumerable(IDoubleEnumerable enumerable, int skip) {
		Arguments.isNotNull(enumerable);
		Arguments.is(skip>=0, "%d < 0", skip);
		
		this.enumerable = enumerable;
		this.skip = skip;
	}
	
	@Override
	public IDoubleEnumerator iterator() {
		IDoubleEnumerator enumerator = enumerable.iterator();
		for(int i=0; i < skip; i++) {
			if(enumerator.hasNext()) {
				enumerator.nextDouble();
			}
		}
		return enumerator;
	}
	
}
