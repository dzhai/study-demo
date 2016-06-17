package net.dzhai.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LruCache delegation实现
 */
public class LruCache<K, V> {

	private Map<K, V> store;
	private final int MAX_CACHE_SIZE;
	private final float DEFAULT_LOAD_FACTOR = 0.75f;

	public LruCache(int cacheSize) {
		MAX_CACHE_SIZE = cacheSize;
		// 根据cacheSize和加载因子计算hashmap的capactiy，+1确保当达到cacheSize上限时不会触发hashmap的扩容，
		int capacity = (int) Math.ceil(MAX_CACHE_SIZE / DEFAULT_LOAD_FACTOR) + 1;
		store = new LinkedHashMap<K, V>(capacity, DEFAULT_LOAD_FACTOR, true) {

			private static final long serialVersionUID = 1L;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > MAX_CACHE_SIZE;
			}
		};
	}

	public V get(K key) {
		synchronized (store) {
			return store.get(key);
		}
	}

	public void put(K key, V value) {
		synchronized (store) {
			store.put(key, value);
		}
	}

	public void remove(K key) {
		synchronized (store) {
			store.remove(key);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<K, V> entry : store.entrySet()) {
			sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LruCache<Integer, String> lru = new LruCache<Integer, String>(5);

		lru.put(1, "11");
		System.out.println(lru.toString());
		lru.put(2, "11");
		System.out.println(lru.toString());
		lru.put(3, "11");
		System.out.println(lru.toString());
		lru.put(4, "11");
		System.out.println(lru.toString());
		lru.put(5, "11");
		System.out.println(lru.toString());
		lru.put(6, "66");
		System.out.println(lru.toString());
		lru.get(2);
		System.out.println(lru.toString());
		lru.put(7, "77");
		System.out.println(lru.toString());
		lru.get(4);
		System.out.println(lru.toString());
	}

}
