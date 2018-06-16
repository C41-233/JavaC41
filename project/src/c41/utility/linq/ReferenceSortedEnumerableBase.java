package c41.utility.linq;

import java.util.Comparator;

import c41.core.assertion.Arguments;

abstract class ReferenceSortedEnumerableBase<T> implements IReferenceSortedEnumerable<T>{

	@Override
	public IReferenceSortedEnumerable<T> thenBy(Comparator<? super T> comparator) {
		Arguments.isNotNull(comparator);
		return new ReferenceThenByEnumerable<>(this, comparator);
	}

	@Override
	public abstract IReferenceSortedEnumerator<T> iterator();
	
}
