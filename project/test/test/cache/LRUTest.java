package test.cache;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import c41.cache.ICacheHandler;
import c41.cache.LRUCache;

public class LRUTest {

	@Test
	public void test() {
		List<String> result = new ArrayList<>();
		LRUCache<Integer, Integer> cache = new LRUCache<>(12, new ICacheHandler<Integer, Integer>() {
			@Override
			public Integer create(Integer key) {
				result.add("create " + key);
				return key;
			}

			@Override
			public void delete(Integer key, Integer value) {
				result.add("delete " + key);
				System.out.println("delete " + key);
			}
		});
		cache.get(1);
		cache.get(2);
		cache.get(3);
		cache.get(4);
		cache.get(5);
		cache.get(6);
		cache.get(7);
		cache.get(8);
		cache.get(9);
		cache.get(10);
		cache.get(11);
		cache.get(12);
		cache.get(13);
	}

}
