package net.dzhai.demo.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache2<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	private final int MAX_CACHE_SIZE;

	public LruCache2(int cacheSize) {
		super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
		MAX_CACHE_SIZE = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > MAX_CACHE_SIZE;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<K, V> entry : entrySet()) {
			sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		LruCache2<Integer, String> lru = new LruCache2<Integer, String>(5);

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
