package c41.cache;

import java.util.Objects;

import c41.core.assertion.Arguments;

public class LRUCache<K, V> implements ICache<K, V>{

	private final Cache<K, V>[] caches;
	private final int capacity;
	private final ICacheHandler<K, V> handler;

	private int pHead;
	private int pEmpty;
	
	@SuppressWarnings("unchecked")
	public LRUCache(int capacity, ICacheHandler<K, V> handler) {
		Arguments.is(capacity > 0, "size = %d", capacity);
		Arguments.isNotNull(handler);
		
		this.capacity = capacity;
		this.caches = new Cache[capacity];
		this.handler = handler;
	}
	
	@Override
	public V get(K key) {
		Cache<K, V> old = getCacheInternal(key);
		if(old != null) {
			return old.value;
		}

		V value = handler.create(key);
		
		if(pEmpty < capacity) {
			Cache<K, V> cache = new Cache<>();
			cache.isUsed = true;
			cache.key = key;
			cache.value = value;
			
			caches[pEmpty] = cache;
			pEmpty++;
			return value;
		}
		
		while(true) {
			Cache<K, V> cache = caches[pHead];
			if(cache.isUsed) {
				cache.isUsed = false;
				pHead++;
				if(pHead >= capacity) {
					pHead = 0;
				}
			}
			else {
				try {
					handler.delete(cache.key, cache.value);
				}
				finally {
					cache.key = key;
					cache.value = value;
					cache.isUsed = true;	
				}
			}
		}
	}

	private Cache<K, V> getCacheInternal(K key) {
		for(int i = pHead; i < capacity; i++) {
			Cache<K, V> cache = caches[i];
			if(cache != null && Objects.equals(cache.key, key)) {
				cache.isUsed = true;
				return cache;
			}
		}
		for(int i = 0; i < pHead; i++) {
			Cache<K, V> cache = caches[i];
			if(cache != null && Objects.equals(cache.key, key)) {
				cache.isUsed = true;
				return cache;
			}
		}
		return null;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getSize() {
		return this.pEmpty;
	}

	@Override
	public void clear() {
		for(int i=0; i<pEmpty; i++) {
			Cache<K, V> cache = caches[i];
			handler.delete(cache.key, cache.value);
			caches[i] = null;
		}
		pHead = 0;
		pEmpty = 0;
	}
	
	@Override
	protected void finalize() throws Throwable {
		clear();
	}
	
	private static class Cache<K, V>{
		public boolean isUsed;
		public K key;
		public V value;
	}

}
