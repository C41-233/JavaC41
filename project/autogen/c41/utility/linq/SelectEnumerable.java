package c41.utility.linq;

import c41.lambda.selector.*;
import c41.utility.linq.enumerator.*;

class ByteSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final IByteEnumerable enumerable;
	private final IByteSelector<V> selector;
	
	public ByteSelectEnumerable(IByteEnumerable enumerable, IByteSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final IByteEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

class CharSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final ICharEnumerable enumerable;
	private final ICharSelector<V> selector;
	
	public CharSelectEnumerable(ICharEnumerable enumerable, ICharSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final ICharEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

class ShortSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final IShortEnumerable enumerable;
	private final IShortSelector<V> selector;
	
	public ShortSelectEnumerable(IShortEnumerable enumerable, IShortSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final IShortEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

class IntSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final IIntEnumerable enumerable;
	private final IIntSelector<V> selector;
	
	public IntSelectEnumerable(IIntEnumerable enumerable, IIntSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final IIntEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

class LongSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final ILongEnumerable enumerable;
	private final ILongSelector<V> selector;
	
	public LongSelectEnumerable(ILongEnumerable enumerable, ILongSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final ILongEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

class FloatSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final IFloatEnumerable enumerable;
	private final IFloatSelector<V> selector;
	
	public FloatSelectEnumerable(IFloatEnumerable enumerable, IFloatSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final IFloatEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

class DoubleSelectEnumerable<V> implements IReferenceEnumerable<V>{

	private final IDoubleEnumerable enumerable;
	private final IDoubleSelector<V> selector;
	
	public DoubleSelectEnumerable(IDoubleEnumerable enumerable, IDoubleSelector<V> selector) {
		this.enumerable = enumerable;
		this.selector = selector;
	}

	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator implements IEnumerator<V>{

		private final IDoubleEnumerator enumerator = enumerable.iterator();
		
		@Override
		public boolean hasNext() {
			return enumerator.hasNext();
		}

		@Override
		public V next() {
			return selector.select(enumerator.next());
		}
		
	}
	
}

