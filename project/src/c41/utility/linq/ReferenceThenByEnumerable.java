package c41.utility.linq;

import java.util.ArrayList;
import java.util.Comparator;

import c41.core.assertion.Arguments;
import c41.utility.linq.enumerator.ReferenceEnumeratorBase;

class ReferenceThenByEnumerable<T> extends ReferenceSortedEnumerableBase<T>{

	private final ReferenceSortedEnumerableBase<T> enumerable;
	private final Comparator<? super T> comparator;
	
	public ReferenceThenByEnumerable(ReferenceSortedEnumerableBase<T> enumerable, Comparator<? super T> comparator) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(comparator);
		
		this.enumerable = enumerable;
		this.comparator = comparator;
	}
	
	@Override
	public IReferenceSortedEnumerator<T> iterator() {
		return new Enumerator();
	}

	@Override
	public IReferenceSortedEnumerable<T> thenBy(Comparator<? super T> comparator) {
		Arguments.isNotNull(comparator);
		return new ReferenceThenByEnumerable<>(this, comparator);
	}
	
	private final class Enumerator extends ReferenceEnumeratorBase<T> implements IReferenceSortedEnumerator<T>{

		private final ArrayList<T> list = new ArrayList<>();
		private IReferenceSortedEnumerator<T> enumerator = enumerable.iterator();
		private int index = -1;

		public Enumerator() {
			if(enumerator.hasNext()) {
				list.add(enumerator.next());
				while(enumerator.hasNextEquals()) {
					list.add(enumerator.next());
				}
				list.sort(comparator);
			}
		}
		
		@Override
		public boolean hasNext() {
			return index+1 < list.size() || enumerator.hasNext();
		}

		@Override
		public T doNext() {
			if(index >= 0) {
				list.set(index, null); //gc
			}
			index++;
			
			if(index >= list.size()) {
				list.clear();
				list.add(enumerator.next());
				while(enumerator.hasNextEquals()) {
					list.add(enumerator.next());
				}
				list.sort(comparator);
				index = 0;
			}
			T current = list.get(index);
			return current;
		}

		@Override
		public boolean hasNextEquals() {
			return index >=0 && index+1 < list.size() && comparator.compare(list.get(index), list.get(index+1)) == 0;
		}
		
	}

}