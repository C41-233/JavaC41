package c41.utility.linq;

import java.util.ArrayList;

import c41.utility.linq.enumerator.IEnumerator;

/**
 * groupBy查询后的组。
 * 
 * @param <TKey> 组所代表的key。
 * @param <TValue> 组所代表的元素。
 */
public interface IReferenceGroup<TKey, TValue> extends IReferenceEnumerable<TValue>{

	public TKey getKey();
	
}

class ReferenceGroup<TKey, TValue> implements IReferenceGroup<TKey, TValue>{

	private final IReferenceEnumerable<TValue> enumerable;

	private final TKey key;
	private final ArrayList<TValue> values;
	
	public ReferenceGroup(TKey key) {
		this.key = key;
		this.values = new ArrayList<>();
		this.enumerable = new IterableEnumerable<>(this.values);
	}
	
	@Override
	public IEnumerator<TValue> iterator() {
		return enumerable.iterator();
	}

	@Override
	public TKey getKey() {
		return key;
	}
	
	public void add(TValue value) {
		this.values.add(value);
	}
	
}