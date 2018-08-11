package c41.utility.comparator;

import java.util.Comparator;

import c41.core.assertion.Arguments;
import c41.lambda.predicate.IPredicate;

public final class ComparatorChain<T> implements Comparator<T>{

	private final Comparator<T> comparator;
	
	ComparatorChain(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	@Override
	public int compare(T o1, T o2) {
		return comparator.compare(o1, o2);
	}

	public ComparatorChain<T> thenBy(Comparator<T> next){
		Arguments.isNotNull(next);
		return new ComparatorChain<>((o1, o2)->{
			int comp = comparator.compare(o1, o2);
			if(comp != 0) {
				return comp;
			}
			return next.compare(o1, o2);
		});
	}
	
	public ComparatorChain<T> thenBy(IPredicate<T> predicate){
		Arguments.isNotNull(predicate);
		return thenBy((o1, o2) -> -Comparators.compare(predicate.invoke(o1), predicate.invoke(o2)));
	}
	
	@SuppressWarnings("unchecked")
	public ComparatorChain<T> thenBySelf(){
		return thenBy((o1, o2) -> Comparators.compare((Comparable)o1, (Comparable)o2));
	}
	
}
