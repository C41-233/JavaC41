package c41.utility.linq;

import java.util.ArrayList;
import java.util.Comparator;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.IEnumerator;
import c41.utility.linq.enumerator.ReferenceEnumeratorBase;

class ReferenceOrderByEnumerable<T> extends ReferenceSortedEnumerableBase<T>{

	private final IEnumerable<T> enumerable;
	private final Comparator<? super T> comparator;
	
	public ReferenceOrderByEnumerable(IEnumerable<T> enumerable, Comparator<? super T> comparator) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(comparator);
		
		this.enumerable = enumerable;
		this.comparator = comparator;
	}
	
	@Override
	public IReferenceSortedEnumerator<T> iterator() {
		return new Enumerator();
	}

	private final class Enumerator extends ReferenceEnumeratorBase<T> implements IReferenceSortedEnumerator<T>{

		private final ArrayList<T> queue = new ArrayList<>();
		private int index = -1;
	
		public Enumerator() {
			IEnumerator<T> enumerator = enumerable.iterator();
			while(enumerator.hasNext()) {
				queue.add(enumerator.next());
			}
			queue.sort(comparator);
		}
		
		@Override
		public boolean hasNext() {
			return index+1 < queue.size();
		}

		@Override
		public boolean hasNextEquals() {
			return index >= 0 && index+1 < queue.size() && comparator.compare(queue.get(index), queue.get(index+1)) == 0;
		}
		
		@Override
		protected T doNext() {
			if(index >= 0) {
				queue.set(index, null); //gc
			}
			++index;
			return queue.get(index);
		}

	}

}
