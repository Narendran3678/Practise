package com.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;

public class CacheBucket { 
	private String cacheName = "" ;
	private Cache<Object,Object> cache;
	
	public CacheBucket(String cacheName, Cache<Object,Object> cache)
	{
		this.cacheName = cacheName;
		this.cache = cache;
	}

	public String getCacheName() {
		return cacheName;
	}
	
	public Cache<Object,Object> getCache() {
		return cache;
	}
	public void put(Object key,Object value) {
		this.cache.put(key, value);
	}
	public CacheStats getCacheStats()
	{
		return this.getCache().stats();
	}
	@Override
	public String toString() {
		return " [ CacheName = " + cacheName + ", Cache = " + cache + "]";
	}
	
	
}
