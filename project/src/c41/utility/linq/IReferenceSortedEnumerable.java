package c41.utility.linq;

import java.util.Comparator;

import c41.core.assertion.Arguments;
import c41.lambda.selector.ISelector;
import c41.utility.comparator.Comparators;
import c41.utility.linq.enumerator.IEnumerator;

/**
 * 引用类型的有序Enumerable。
 * @param <T> 查询元素
 */
public interface IReferenceSortedEnumerable<T> extends IReferenceEnumerable<T>{

	public IReferenceSortedEnumerable<T> thenBy(Comparator<? super T> comparator);

	public default <V extends Comparable<? super V>> IReferenceSortedEnumerable<T> thenBy(ISelector<T, V> selector){
		Arguments.isNotNull(selector);
		return thenBy((t1, t2)->Comparators.compare(selector.select(t1), selector.select(t2)));
	}
	
	@SuppressWarnings("unchecked")
	public default IReferenceSortedEnumerable<T> thenBySelf(){
		return thenBy((t1, t2)->{
			return Comparators.compare((Comparable)t1, (Comparable)t2);
		});
	}
	
}

interface IReferenceSortedEnumerator<T> extends IEnumerator<T>{

	public boolean hasNextEquals();
	
}


abstract class ReferenceSortedEnumerableBase<T> implements IReferenceSortedEnumerable<T>{

	@Override
	public IReferenceSortedEnumerable<T> thenBy(Comparator<? super T> comparator) {
		Arguments.isNotNull(comparator);
		return new ReferenceThenByEnumerable<>(this, comparator);
	}

	@Override
	public abstract IReferenceSortedEnumerator<T> iterator();
	
}
