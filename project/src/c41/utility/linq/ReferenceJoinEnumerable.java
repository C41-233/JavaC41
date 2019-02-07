package c41.utility.linq;

import java.util.Iterator;

import c41.core.assertion.Arguments;
import c41.lambda.function.IJoiner;
import c41.utility.linq.enumerator.IEnumerator;
import c41.utility.linq.enumerator.ReferenceEnumeratorBase;

/**
 * 笛卡尔积。
 *
 * @param <T> 类型1
 * @param <U> 类型2
 * @param <V> 合并类型
 */
class ReferenceJoinEnumerable<T, U, V> implements IReferenceEnumerable<V>{

	private final Iterable<T> iterable1;
	private final Iterable<U> iterable2;
	private final IJoiner<T, U, V> joiner;
	
	public ReferenceJoinEnumerable(Iterable<T> iterable1, Iterable<U> iterable2, IJoiner<T, U, V> joiner) {
		Arguments.isNotNull(iterable1);
		Arguments.isNotNull(iterable2);
		Arguments.isNotNull(joiner);
		
		this.iterable1 = iterable1;
		this.iterable2 = iterable2;
		this.joiner = joiner;
	}
	
	@Override
	public IEnumerator<V> iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends ReferenceEnumeratorBase<V>{

		private final Iterator<T> iterator1 = iterable1.iterator();
		private Iterator<U> iterator2 = iterable2.iterator();
		
		private T t;
		
		private boolean hasT;
		
		@Override
		public boolean hasNext() {
			if(hasT == false && iterator1.hasNext() == false) {
				return false;
			}
			
			if(iterator2.hasNext() == true) {
				return true;
				
			}
			if(iterator1.hasNext() == false) {
				return false;
			}
			
			iterator2 = iterable2.iterator();
			t = null;
			hasT = false;
			return iterator2.hasNext();
		}

		@Override
		public V doNext() {
			if(hasT == false) {
				t = iterator1.next();
				hasT = true;
			}
			
			U u = iterator2.next();
			V v = joiner.join(t, u);
			return v;
		}
		
	}
	
}
