package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.*;

class ByteArrayEnumerable implements IByteEnumerable{

	private final byte[] array;

	public ByteArrayEnumerable(byte[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public byte[] toArray() {
		return array.clone();
	}
	
	@Override
	public IByteEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends ByteEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected byte doNext() {
			return array[++i];
		}
		
	}
	
}

class CharArrayEnumerable implements ICharEnumerable{

	private final char[] array;

	public CharArrayEnumerable(char[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public char[] toArray() {
		return array.clone();
	}
	
	@Override
	public ICharEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends CharEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected char doNext() {
			return array[++i];
		}
		
	}
	
}

class ShortArrayEnumerable implements IShortEnumerable{

	private final short[] array;

	public ShortArrayEnumerable(short[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public short[] toArray() {
		return array.clone();
	}
	
	@Override
	public IShortEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends ShortEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected short doNext() {
			return array[++i];
		}
		
	}
	
}

class IntArrayEnumerable implements IIntEnumerable{

	private final int[] array;

	public IntArrayEnumerable(int[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public int[] toArray() {
		return array.clone();
	}
	
	@Override
	public IIntEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends IntEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected int doNext() {
			return array[++i];
		}
		
	}
	
}

class LongArrayEnumerable implements ILongEnumerable{

	private final long[] array;

	public LongArrayEnumerable(long[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public long[] toArray() {
		return array.clone();
	}
	
	@Override
	public ILongEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends LongEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected long doNext() {
			return array[++i];
		}
		
	}
	
}

class FloatArrayEnumerable implements IFloatEnumerable{

	private final float[] array;

	public FloatArrayEnumerable(float[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public float[] toArray() {
		return array.clone();
	}
	
	@Override
	public IFloatEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends FloatEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected float doNext() {
			return array[++i];
		}
		
	}
	
}

class DoubleArrayEnumerable implements IDoubleEnumerable{

	private final double[] array;

	public DoubleArrayEnumerable(double[] array) {
		Arguments.isNotNull(array);
		this.array = array;
	}
	
	@Override
	public int count() {
		return array.length;
	}
	
	@Override
	public double[] toArray() {
		return array.clone();
	}
	
	@Override
	public IDoubleEnumerator iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends DoubleEnumeratorBase{

		private int i = -1;
		
		@Override
		public boolean hasNext() {
			return i+1 < array.length;
		}

		@Override
		protected double doNext() {
			return array[++i];
		}
		
	}
	
}

