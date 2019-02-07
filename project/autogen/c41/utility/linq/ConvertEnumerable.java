package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.lambda.selector.*;
import c41.utility.linq.enumerator.*;

class ConvertByteEnumerable<T> implements IByteEnumerable{

	private final IEnumerable<T> enumerable;
	private final IByteConverter<T> converter;
	
	public ConvertByteEnumerable(IEnumerable<T> enumerable, IByteConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public IByteEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements IByteEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public byte nextByte() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

class ConvertCharEnumerable<T> implements ICharEnumerable{

	private final IEnumerable<T> enumerable;
	private final ICharConverter<T> converter;
	
	public ConvertCharEnumerable(IEnumerable<T> enumerable, ICharConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public ICharEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements ICharEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public char nextChar() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

class ConvertShortEnumerable<T> implements IShortEnumerable{

	private final IEnumerable<T> enumerable;
	private final IShortConverter<T> converter;
	
	public ConvertShortEnumerable(IEnumerable<T> enumerable, IShortConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public IShortEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements IShortEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public short nextShort() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

class ConvertIntEnumerable<T> implements IIntEnumerable{

	private final IEnumerable<T> enumerable;
	private final IIntConverter<T> converter;
	
	public ConvertIntEnumerable(IEnumerable<T> enumerable, IIntConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public IIntEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements IIntEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public int nextInt() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

class ConvertLongEnumerable<T> implements ILongEnumerable{

	private final IEnumerable<T> enumerable;
	private final ILongConverter<T> converter;
	
	public ConvertLongEnumerable(IEnumerable<T> enumerable, ILongConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public ILongEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements ILongEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public long nextLong() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

class ConvertFloatEnumerable<T> implements IFloatEnumerable{

	private final IEnumerable<T> enumerable;
	private final IFloatConverter<T> converter;
	
	public ConvertFloatEnumerable(IEnumerable<T> enumerable, IFloatConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public IFloatEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements IFloatEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public float nextFloat() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

class ConvertDoubleEnumerable<T> implements IDoubleEnumerable{

	private final IEnumerable<T> enumerable;
	private final IDoubleConverter<T> converter;
	
	public ConvertDoubleEnumerable(IEnumerable<T> enumerable, IDoubleConverter<T> converter) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(converter);
		
		this.enumerable = enumerable;
		this.converter = converter;
	}
	
	@Override
	public IDoubleEnumerator iterator() {
		return new Enumerator();
	}
	
	private final class Enumerator implements IDoubleEnumerator{

		private final IEnumerator<T> enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public double nextDouble() {
			return converter.convert(enumerator.next());
		}
		
	}
	
}

