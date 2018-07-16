package c41.cache;

public interface ICacheHandler<K ,V> {

	public V create(K key);
	
	public void delete(K key, V value);
	
}
