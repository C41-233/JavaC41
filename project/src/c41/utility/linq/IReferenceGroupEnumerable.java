package c41.utility.linq;

import c41.utility.linq.enumerator.IEnumerator;

public interface IReferenceGroupEnumerable<K, V> extends IReferenceEnumerable<IReferenceGroup<K, V>>{
	
	@Override
	public IEnumerator<IReferenceGroup<K, V>> iterator();
	
}
