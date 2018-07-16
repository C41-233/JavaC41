package c41.cache;

public interface ICache<K, V> {

	public V get(K key);

	public void clear();
	
}
