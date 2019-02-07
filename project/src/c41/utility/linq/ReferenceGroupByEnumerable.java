package c41.utility.linq;

import c41.core.assertion.Arguments;
import c41.lambda.selector.ISelector;
import c41.utility.collection.map.DefaultValueHashMap;
import c41.utility.linq.enumerator.IEnumerator;

class ReferenceGroupByEnumerable<K, V> implements IReferenceEnumerable<IReferenceGroup<K, V>>{

	private final IEnumerable<V> enumerable;
	private final ISelector<V, K> selector;
	
	public ReferenceGroupByEnumerable(IEnumerable<V> enumerable, ISelector<V, K> selector) {
		Arguments.isNotNull(enumerable);
		Arguments.isNotNull(selector);

		this.enumerable = enumerable;
		this.selector = selector;
	}
	
	@Override
	public IEnumerator<IReferenceGroup<K, V>> iterator() {
		IEnumerator<V> enumerator = enumerable.iterator();
		DefaultValueHashMap<K, ReferenceGroup<K, V>> keyToGroups = new DefaultValueHashMap<>(key -> new ReferenceGroup<>(key));
		while(enumerator.hasNext()) {
			V value = enumerator.next();
			K key = selector.select(value);
			ReferenceGroup<K, V> group = keyToGroups.get(key);
			group.add(value);
		}
		return Linq.from(keyToGroups.values()).<IReferenceGroup<K, V>>cast().iterator();
	}
	
}
